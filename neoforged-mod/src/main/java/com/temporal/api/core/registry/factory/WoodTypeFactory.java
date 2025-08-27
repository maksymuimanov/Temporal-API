package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class WoodTypeFactory {
    private WoodTypeFactory() {
    }

    public static WoodType create(String name, BlockSetType blockSetType) {
        return new WoodType(IOLayer.NEO_MOD.getModId() + ":" + name, blockSetType);
    }
}
