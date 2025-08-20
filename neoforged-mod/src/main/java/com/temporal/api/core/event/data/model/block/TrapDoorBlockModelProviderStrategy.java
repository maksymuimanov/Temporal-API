package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;

import static com.temporal.api.core.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class TrapDoorBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        TrapDoorBlock block = (TrapDoorBlock) blockRegistry.value();
        String blockPath = provider.getBlockPath(block);
        ResourceLocation texture = ResourceUtils.parse(blockPath);
        provider.trapdoorBlockWithRenderType(block, texture, true, MINECRAFT_CUTOUT);
    }
}
