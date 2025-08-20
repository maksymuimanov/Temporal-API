package com.temporal.api.core.registry.factory.other;

import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public final class TreeGrowerFactory {
    private TreeGrowerFactory() {
    }

    public static TreeGrower create(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return new TreeGrower(IOLayer.NEO_MOD.getModId() + ":" + name,
                Optional.empty(),
                Optional.of(tree),
                Optional.empty());
    }
}
