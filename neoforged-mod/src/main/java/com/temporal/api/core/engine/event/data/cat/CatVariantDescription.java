package com.temporal.api.core.engine.event.data.cat;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;

public record CatVariantDescription(ResourceKey<CatVariant> variant) {
}
