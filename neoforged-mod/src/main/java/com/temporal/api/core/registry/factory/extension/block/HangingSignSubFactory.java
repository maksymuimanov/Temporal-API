package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface HangingSignSubFactory {
    default DeferredBlock<CeilingHangingSignBlock> createCeilingHangingSignWithoutItem(String name, float strength, WoodType woodType) {
        return createCeilingHangingSignWithoutItem(name, BlockPropertiesFactory.wood(), strength, woodType);
    }

    default DeferredBlock<CeilingHangingSignBlock> createCeilingHangingSignWithoutItem(String name, BlockBehaviour.Properties properties, float strength, WoodType woodType) {
        BlockFactory factory = InjectionPool.getFromInstance(BlockFactory.class);
        return factory.createWithoutItem(name, properties.mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), props -> new CeilingHangingSignBlock(woodType, props));
    }

    default DeferredBlock<WallHangingSignBlock> createWallHangingSignWithoutItem(String name, float strength, WoodType woodType) {
        return createWallHangingSignWithoutItem(name, BlockPropertiesFactory.wood(), strength, woodType);
    }

    default DeferredBlock<WallHangingSignBlock> createWallHangingSignWithoutItem(String name, BlockBehaviour.Properties properties, float strength, WoodType woodType) {
        BlockFactory factory = InjectionPool.getFromInstance(BlockFactory.class);
        return factory.createWithoutItem(name, properties.mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), props -> new WallHangingSignBlock(woodType, props));
    }
}
