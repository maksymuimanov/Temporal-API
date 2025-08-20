package com.temporal.api.core.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class BowClientSetupStrategy implements ClientSetupStrategy<DeferredItem<?>> {
    @Override
    public void execute(List<DeferredItem<?>> source) {
        source.stream()
                .map(DeferredHolder::get)
                .forEach(bow -> {
                    registerPull(bow);
                    registerPulling(bow);
                });
    }

    private void registerPull(Item bow) {
        ItemProperties.register(
                bow, ResourceLocation.withDefaultNamespace("pull"),
                (stack, level, entity, seed) ->
                        entity == null ? 0.0F : entity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F
        );
    }

    private void registerPulling(Item bow) {
        ItemProperties.register(
                bow, ResourceLocation.withDefaultNamespace("pulling"),
                (item, level, entity, seed) ->
                        entity != null && entity.isUsingItem() && entity.getUseItem() == item ? 1.0F : 0.0F
        );
    }
}
