package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.ModContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public final class TreeGrowerFactory {
    private TreeGrowerFactory() {
    }

    public static TreeGrower create(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return create(name, null, tree, null);
    }

    public static TreeGrower create(String name, ResourceKey<ConfiguredFeature<?, ?>> megaTree, ResourceKey<ConfiguredFeature<?, ?>> tree, ResourceKey<ConfiguredFeature<?, ?>> flowers) {
        return new TreeGrower(ModContext.NEO_MOD.getModId() + ":" + name,
                Optional.ofNullable(megaTree),
                Optional.of(tree),
                Optional.ofNullable(flowers));
    }
}
