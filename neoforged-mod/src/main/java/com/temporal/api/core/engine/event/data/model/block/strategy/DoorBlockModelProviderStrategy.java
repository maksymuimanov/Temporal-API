package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DoorBlock;

public class DoorBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        DoorBlock block = spec.getBlock();
        ResourceLocation bottomTexture = spec.getLocation(ModelConstants.BOTTOM_SUFFIX);
        ResourceLocation topTexture = spec.getLocation(ModelConstants.TOP_SUFFIX);
        provider.doorBlockWithRenderType(block, bottomTexture, topTexture, spec.getRenderType());
    }
}
