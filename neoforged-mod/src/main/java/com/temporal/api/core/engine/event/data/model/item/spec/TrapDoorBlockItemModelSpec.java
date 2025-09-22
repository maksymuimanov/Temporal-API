package com.temporal.api.core.engine.event.data.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TrapDoorBlockItemModelSpec extends BlockItemModelSpec {
    private final boolean orientable;

    public TrapDoorBlockItemModelSpec(Holder<? extends Item> holder, boolean orientable) {
        super(holder);
        this.orientable = orientable;
    }

    public TrapDoorBlockItemModelSpec(Holder<? extends Item> holder, String blockId, boolean orientable) {
        super(holder, blockId);
        this.orientable = orientable;
    }

    public TrapDoorBlockItemModelSpec(Holder<? extends Item> holder, Block block, boolean orientable) {
        super(holder, block);
        this.orientable = orientable;
    }

    public boolean isOrientable() {
        return orientable;
    }
}
