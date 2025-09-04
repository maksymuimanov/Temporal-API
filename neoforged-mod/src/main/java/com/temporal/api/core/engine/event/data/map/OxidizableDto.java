package com.temporal.api.core.engine.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public record OxidizableDto(Holder<? extends Block> block, String nextStageBlockId, boolean replace) {
}