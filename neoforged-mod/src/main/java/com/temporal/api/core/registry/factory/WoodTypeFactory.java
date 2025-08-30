package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class WoodTypeFactory {
    private WoodTypeFactory() {
    }

    public static WoodType create(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
        return WoodType.register(new WoodType(IOLayer.NEO_MOD.getModId() + ":" + name, setType, soundType, hangingSignSoundType, fenceGateClose, fenceGateOpen));
    }

    public static WoodType create(String name, BlockSetType setType) {
        return WoodType.register(new WoodType(IOLayer.NEO_MOD.getModId() + ":" + name, setType));
    }
}
