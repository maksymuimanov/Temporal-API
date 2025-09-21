package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.ButtonBlock;

public class ButtonBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<ButtonBlock>otherBlockTexture(spec, provider::buttonBlock);
    }
}
