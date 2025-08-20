package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface SignSubFactory {
    default DeferredBlock<StandingSignBlock> createStandingSignWithoutItem(String name, float strength, WoodType woodType) {
        return createStandingSignWithoutItem(name, BlockPropertiesFactory.wood(), strength, woodType);
    }

    default DeferredBlock<StandingSignBlock> createStandingSignWithoutItem(String name, BlockBehaviour.Properties properties, float strength, WoodType woodType) {
        BlockFactory factory = InjectionPool.getFromInstance(BlockFactory.class);
        return factory.createWithoutItem(name, properties.mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), props -> new StandingSignBlock(woodType, props));
    }

    default DeferredBlock<WallSignBlock> createWallSignWithoutItem(String name, float strength, WoodType woodType) {
        return createWallSignWithoutItem(name, BlockPropertiesFactory.wood(), strength, woodType);
    }

    default DeferredBlock<WallSignBlock> createWallSignWithoutItem(String name, BlockBehaviour.Properties properties, float strength, WoodType woodType) {
        BlockFactory factory = InjectionPool.getFromInstance(BlockFactory.class);
        return factory.createWithoutItem(name, properties.mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), props -> new WallSignBlock(woodType, props));
    }
}
