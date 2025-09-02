package com.temporal.api.core.engine.registry.factory;

import com.mojang.datafixers.types.Type;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockEntityTypeFactory extends AbstractObjectFactory<BlockEntityType<?>> {
    public BlockEntityTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockEntityTypes"));
    }

    public BlockEntityTypeFactory(TemporalRegister<BlockEntityType<?>> blockEntityTypes) {
        super(blockEntityTypes);
    }

    public <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> create(String name, BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
        return this.create(name, factory, null, blocks);
    }

    public <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> create(String name, BlockEntityType.BlockEntitySupplier<T> factory, Type<?> type, Block... blocks) {
        return this.create(name, () -> BlockEntityType.Builder.of(factory, blocks).build(type));
    }
}
