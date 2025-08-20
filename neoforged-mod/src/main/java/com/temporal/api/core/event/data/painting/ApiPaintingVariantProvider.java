package com.temporal.api.core.event.data.painting;

import com.temporal.api.core.collection.TemporalQueue;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.Queue;

public class ApiPaintingVariantProvider implements PaintingVariantProvider {
    public static final Queue<PaintingHolder> PAINTINGS = new TemporalQueue<>();

    @Override
    public void registerPaintingVariant(BootstrapContext<PaintingVariant> context) {
        PAINTINGS.forEach(description -> {
            ResourceKey<PaintingVariant> variant = description.paintingVariant();
            context.register(variant, new PaintingVariant(description.width(), description.height(), variant.location()));
        });
    }

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        PaintingVariantProvider provider = new ApiPaintingVariantProvider();
        provider.registerPaintingVariant(context);
    }
}
