package com.temporal.api.core.engine.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.List;

public class ShieldClientSetupStrategy implements ClientSetupStrategy<Holder<? extends Item>> {
    @Override
    public void execute(List<Holder<? extends Item>> source) {
        source.stream()
                .map(Holder::value)
                .forEach(shield -> {
                    ItemProperties.register(shield,
                            ResourceLocation.withDefaultNamespace("blocking"),
                            (item, level, entity, seed) ->
                                    entity != null && entity.isUsingItem() && entity.getUseItem() == item ? 1.0F : 0.0F);
                });
    }
}
