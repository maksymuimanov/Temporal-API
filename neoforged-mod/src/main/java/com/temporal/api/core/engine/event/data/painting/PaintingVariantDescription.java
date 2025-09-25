package com.temporal.api.core.engine.event.data.painting;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public record PaintingVariantDescription(ResourceKey<PaintingVariant> paintingVariant, int width, int height) {
}
