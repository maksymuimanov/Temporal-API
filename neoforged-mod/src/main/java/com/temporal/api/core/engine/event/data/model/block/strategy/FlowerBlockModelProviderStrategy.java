package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

public class FlowerBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        provider.simpleBlock(block, provider.models()
                .cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), provider.blockTexture(block))
                .renderType(spec.getRenderType()));
        provider.simpleBlock(spec.getDependencyBlock(), provider.models()
                .withExistingParent(spec.getDependencyPath(), provider.mcLoc("block/flower_pot_cross"))
                .texture("plant", spec.getPath())
                .renderType(spec.getRenderType()));
    }
}
