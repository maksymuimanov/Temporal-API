package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;

public class PressurePlateBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((PressurePlateBlock) blockRegistry.value(), additionalData[0],
                provider::pressurePlateBlock);
    }
}
