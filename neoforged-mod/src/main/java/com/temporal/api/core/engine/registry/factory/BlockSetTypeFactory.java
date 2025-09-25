package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.ModContext;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class BlockSetTypeFactory {
    private BlockSetTypeFactory() {
    }

    public static BlockSetType createWood(String name) {
        return new BlockSetType(ModContext.NEO_MOD.getModId() + ":" + name);
    }

    public static BlockSetType create(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, BlockSetType.PressurePlateSensitivity pressurePlateSensitivity, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        return BlockSetType.register(new BlockSetType(ModContext.NEO_MOD.getModId() + ":" + name, canOpenByHand, canOpenByWindCharge, canButtonBeActivatedByArrows, pressurePlateSensitivity, soundType, doorClose, doorOpen, trapdoorClose, trapdoorOpen, pressurePlateClickOff, pressurePlateClickOn, buttonClickOff, buttonClickOn));
    }
}
