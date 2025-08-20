package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;

import static com.temporal.api.core.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class DoorBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        DoorBlock block = (DoorBlock) blockRegistry.value();
        String blockPath = provider.getBlockPath(block);
        provider.doorBlockWithRenderType(block, ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top"), MINECRAFT_CUTOUT);
    }
}
