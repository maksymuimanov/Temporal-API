package com.temporal.api.core.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class ShieldClientSetupStrategy implements ClientSetupStrategy<DeferredItem<?>> {
    @Override
    public void execute(List<DeferredItem<?>> source) {
        source.stream()
                .map(DeferredHolder::get)
                .forEach(shield -> {
                    ItemProperties.register(shield,
                            ResourceLocation.withDefaultNamespace("blocking"),
                            (item, level, entity, seed) ->
                                    entity != null && entity.isUsingItem() && entity.getUseItem() == item ? 1.0F : 0.0F);
                });
    }
}
