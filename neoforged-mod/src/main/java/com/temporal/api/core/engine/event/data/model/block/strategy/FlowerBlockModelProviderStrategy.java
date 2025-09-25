package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class FlowerBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    public static final String MODEL_PARENT = "block/flower_pot_cross";
    public static final String PLANT_KEY = "plant";

    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        ResourceLocation texture = spec.getLocation();
        provider.simpleBlock(block, provider.models()
                .cross(blockPath, texture)
                .renderType(spec.getRenderType()));
        Block dependencyBlock = spec.getDependencyBlock();
        String dependencyBlockPath = spec.getDependencyPath();
        provider.simpleBlock(dependencyBlock, provider.models()
                .withExistingParent(dependencyBlockPath, provider.mcLoc(MODEL_PARENT))
                .texture(PLANT_KEY, blockPath)
                .renderType(spec.getRenderType()));
    }
}
