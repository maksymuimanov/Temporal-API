package com.temporal.api.core.event.data.painting;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public record PaintingHolder(ResourceKey<PaintingVariant> paintingVariant, int width, int height) {
}
