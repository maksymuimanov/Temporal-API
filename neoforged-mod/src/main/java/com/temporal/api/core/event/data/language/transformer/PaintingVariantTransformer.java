package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class PaintingVariantTransformer implements KeyTransformer<ResourceKey<PaintingVariant>> {
    @Override
    public String transform(ResourceKey<PaintingVariant> paintingVariant) {
        return this.transformResourceKey("painting", paintingVariant) + ".title";
    }
}
