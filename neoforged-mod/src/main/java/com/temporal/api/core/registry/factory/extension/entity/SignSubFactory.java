package com.temporal.api.core.registry.factory.extension.entity;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockEntityTypeFactory;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public interface SignSubFactory {
    default DeferredHolder<BlockEntityType<?>, BlockEntityType<SignBlockEntity>> createSign(String name, Supplier<StandingSignBlock> standingSignBlock, Supplier<WallSignBlock> wallSignBlock) {
        BlockEntityTypeFactory factory = InjectionPool.getFromInstance(BlockEntityTypeFactory.class);
        return factory.create(name, SignBlockEntity::new, standingSignBlock.get(), wallSignBlock.get());
    }
}
