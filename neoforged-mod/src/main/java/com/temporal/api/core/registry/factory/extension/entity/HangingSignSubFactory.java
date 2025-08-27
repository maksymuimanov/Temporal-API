package com.temporal.api.core.registry.factory.extension.entity;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockEntityTypeFactory;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public interface HangingSignSubFactory {
    default DeferredHolder<BlockEntityType<?>, BlockEntityType<HangingSignBlockEntity>> createHangingSign(String name, Supplier<CeilingHangingSignBlock> ceilingSignBlock, Supplier<WallHangingSignBlock> wallSignBlock) {
        BlockEntityTypeFactory factory = InjectionPool.getFromInstance(BlockEntityTypeFactory.class);
        return factory.create(name, HangingSignBlockEntity::new, ceilingSignBlock.get(), wallSignBlock.get());
    }
}
