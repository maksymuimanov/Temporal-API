package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.WallBlock;

public class WallBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<WallBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.wallBlockWithRenderType(block, parentTexture, spec.getRenderType()));
    }
}
