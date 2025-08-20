package com.temporal.api.core.event.data.map;

import net.neoforged.neoforge.registries.DeferredBlock;

public record WaxableDto(DeferredBlock<?> block, String waxedBlock, boolean replace) {
}