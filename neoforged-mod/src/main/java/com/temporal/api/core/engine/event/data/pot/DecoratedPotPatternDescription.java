package com.temporal.api.core.engine.event.data.pot;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public record DecoratedPotPatternDescription(ResourceKey<DecoratedPotPattern> pattern) {
}
