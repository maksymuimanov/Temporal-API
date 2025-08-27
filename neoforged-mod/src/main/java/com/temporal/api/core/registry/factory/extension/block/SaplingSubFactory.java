package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import com.temporal.api.core.registry.factory.TreeGrowerFactory;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface SaplingSubFactory {
    default DeferredBlock<SaplingBlock> createSapling(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return this.createSapling(name, BlockPropertiesFactory.sapling(), tree);
    }

    default DeferredBlock<SaplingBlock> createSapling(String name, BlockBehaviour.Properties properties, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return this.createSapling(name, properties, TreeGrowerFactory.create(name, tree));
    }

    default DeferredBlock<SaplingBlock> createSapling(String name, BlockBehaviour.Properties properties, TreeGrower treeGrower) {
        return this.createSapling(name, properties, new Item.Properties(), treeGrower);
    }

    default DeferredBlock<SaplingBlock> createSapling(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, TreeGrower treeGrower) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.noOcclusion().noCollission(), props -> new SaplingBlock(treeGrower, props), itemProperties);
    }
}
