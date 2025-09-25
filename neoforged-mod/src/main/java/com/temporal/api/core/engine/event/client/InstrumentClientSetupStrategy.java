package com.temporal.api.core.engine.event.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.List;

public class InstrumentClientSetupStrategy implements ClientSetupStrategy<Holder<? extends Item>> {
    public static final String TOOTING = "tooting";

    @Override
    public void execute(List<Holder<? extends Item>> source) {
        source.stream()
                .map(Holder::value)
                .forEach(instrument -> {
                    ItemProperties.register(
                            instrument,
                            ResourceLocation.withDefaultNamespace(TOOTING),
                            (item, level, entity, seed) ->
                                    entity != null && entity.isUsingItem() && entity.getUseItem() == item ? 1.0F : 0.0F
                    );
                });
    }
}
