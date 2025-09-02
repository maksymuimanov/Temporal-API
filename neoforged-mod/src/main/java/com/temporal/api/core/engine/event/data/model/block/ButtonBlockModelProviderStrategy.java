package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;

public class ButtonBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((ButtonBlock) blockRegistry.value(), additionalData[0], provider::buttonBlock);
    }
}
