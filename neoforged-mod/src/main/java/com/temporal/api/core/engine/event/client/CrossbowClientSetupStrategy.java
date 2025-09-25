package com.temporal.api.core.engine.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;

import java.util.List;

public class CrossbowClientSetupStrategy implements ClientSetupStrategy<Holder<? extends Item>> {

    public static final String PULL = "pull";
    public static final String PULLING = "pulling";
    public static final String CHARGED = "charged";
    public static final String FIREWORK = "firework";

    @Override
    public void execute(List<Holder<? extends Item>> source) {
        source.stream()
                .map(Holder::value)
                .forEach(crossbow -> {
                    registerPull(crossbow);
                    registerPulling(crossbow);
                    registerCharged(crossbow);
                    registerChargedFirework(crossbow);
                });
    }

    private void registerPull(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace(PULL),
                (item, level, entity, seed) -> {
                    if (entity == null) return 0.0F;
                    else return CrossbowItem.isCharged(item) ? 0.0F : (float)(item.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(item, entity);
        });
    }

    private void registerPulling(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace(PULLING),
                (item, level, entity, seed) ->
                        entity != null
                        && entity.isUsingItem()
                        && entity.getUseItem() == item
                        && !CrossbowItem.isCharged(item) ? 1.0F : 0.0F
        );
    }

    private void registerCharged(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace(CHARGED),
                (item, level, entity, seed) ->
                        entity != null
                        && CrossbowItem.isCharged(item) ? 1.0F : 0.0F
        );
    }

    private void registerChargedFirework(Item crossbow) {
        ItemProperties.register(crossbow,
                ResourceLocation.withDefaultNamespace(FIREWORK),
                (item, level, entity, seed) -> {
                    ChargedProjectiles chargedprojectiles = item.get(DataComponents.CHARGED_PROJECTILES);
                    return entity != null
                            && chargedprojectiles != null
                            && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
                }
        );
    }
}
