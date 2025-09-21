package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.TrapDoorBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.TrapDoorBlock;

public class TrapDoorBlockModelProviderStrategy implements BlockModelProviderStrategy<TrapDoorBlockModelSpec> {
    @Override
    public void registerBlockModel(TrapDoorBlockModelSpec spec, ApiBlockModelProvider provider) {
        TrapDoorBlock block = spec.getBlock();
        ResourceLocation texture = spec.getLocation();
        provider.trapdoorBlockWithRenderType(block, texture, spec.isOrientable(), spec.getRenderType());
    }
}
