package com.temporal.api.core.registry.factory;

import com.mojang.datafixers.types.Type;
import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityTypeFactory extends AbstractObjectFactory<BlockEntityType<?>> {
    public BlockEntityTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockEntityTypes"));
    }

    public BlockEntityTypeFactory(DeferredRegister<BlockEntityType<?>> blockEntityTypes) {
        super(blockEntityTypes);
    }

    public <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> create(String name, BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, name);
        return this.create(name, () -> BlockEntityType.Builder.of(factory, blocks).build(type));
    }
}
