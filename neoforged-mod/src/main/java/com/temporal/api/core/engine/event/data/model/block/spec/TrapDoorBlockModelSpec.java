package com.temporal.api.core.engine.event.data.model.block.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class TrapDoorBlockModelSpec extends BlockModelSpec {
    private final boolean orientable;

    public TrapDoorBlockModelSpec(Holder<? extends Block> holder, boolean orientable) {
        this(holder, null, orientable);
    }

    public TrapDoorBlockModelSpec(Holder<? extends Block> holder, String renderType, boolean orientable) {
        super(holder, renderType);
        this.orientable = orientable;
    }

    public boolean isOrientable() {
        return orientable;
    }
}
