package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.FenceGateBlock;

public class FenceGateBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<FenceGateBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.fenceGateBlockWithRenderType(block, parentTexture, spec.getRenderType()));
    }
}
