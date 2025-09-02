package com.temporal.api.core.engine.event.data.map;

import net.neoforged.neoforge.registries.DeferredBlock;

public record OxidizableDto(DeferredBlock<?> block, String nextStageBlockId, boolean replace) {
}