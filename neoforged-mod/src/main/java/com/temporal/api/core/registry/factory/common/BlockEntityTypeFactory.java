package com.temporal.api.core.registry.factory.common;

import com.mojang.datafixers.types.Type;
import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityTypeFactory extends AbstractObjectFactory<BlockEntityType<?>> {
    private final DeferredRegister<BlockEntityType<?>> blockEntityTypes;

    public BlockEntityTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockEntityTypes"));
    }

    public BlockEntityTypeFactory(DeferredRegister<BlockEntityType<?>> blockEntityTypes) {
        this.blockEntityTypes = blockEntityTypes;
    }

    public <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> create(String name, BlockEntityType.BlockEntitySupplier<T> factory, Type<?> dataType, Block... blocks) {
        return this.create(name, () -> BlockEntityType.Builder.of(factory, blocks)
                .build(dataType));
    }

    @Override
    public DeferredRegister<BlockEntityType<?>> getRegistry() {
        return blockEntityTypes;
    }
}
