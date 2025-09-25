package com.temporal.api.core.engine.event.data.loot.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class BlockLootTableSpec {
    private final Holder<? extends Block> holder;

    public BlockLootTableSpec(Holder<? extends Block> holder) {
        this.holder = holder;
    }

    @SuppressWarnings("unchecked")
    public <T extends Block> T getBlock() {
        return (T) this.getHolder().value();
    }

    public Holder<? extends Block> getHolder() {
        return holder;
    }
}
