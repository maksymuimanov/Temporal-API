package com.temporal.api.core.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class CrossbowClientSetupStrategy implements ClientSetupStrategy<DeferredItem<?>> {
    @Override
    public void execute(List<DeferredItem<?>> source) {
        source.stream()
                .map(DeferredHolder::get)
                .forEach(crossbow -> {
                    registerPull(crossbow);
                    registerPulling(crossbow);
                    registerCharged(crossbow);
                    registerChargedFirework(crossbow);
                });
    }

    private void registerPull(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace("pull"),
                (item, level, entity, seed) -> {
                    if (entity == null) return 0.0F;
                    else return CrossbowItem.isCharged(item) ? 0.0F : (float)(item.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(item, entity);
        });
    }

    private void registerPulling(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace("pulling"),
                (item, level, entity, seed) ->
                        entity != null
                        && entity.isUsingItem()
                        && entity.getUseItem() == item
                        && !CrossbowItem.isCharged(item) ? 1.0F : 0.0F
        );
    }

    private void registerCharged(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace("charged"),
                (item, level, entity, seed) ->
                        entity != null
                        && CrossbowItem.isCharged(item) ? 1.0F : 0.0F
        );
    }

    private void registerChargedFirework(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace("firework"),
                (item, level, entity, seed) -> {
                    ChargedProjectiles chargedprojectiles = item.get(DataComponents.CHARGED_PROJECTILES);
                    return entity != null
                            && chargedprojectiles != null
                            && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
                }
        );
    }
}
