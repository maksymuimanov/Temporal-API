package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.SlabBlock;

public class SlabBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<SlabBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.slabBlock(block, parentTexture, parentTexture));
    }
}
