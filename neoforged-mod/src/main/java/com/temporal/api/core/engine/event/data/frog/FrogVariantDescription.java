package com.temporal.api.core.engine.event.data.frog;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.FrogVariant;

public record FrogVariantDescription(ResourceKey<FrogVariant> variant) {
}
