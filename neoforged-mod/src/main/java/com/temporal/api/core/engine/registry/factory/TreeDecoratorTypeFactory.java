package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TreeDecoratorTypeFactory extends AbstractObjectFactory<TreeDecoratorType<?>> {
    public TreeDecoratorTypeFactory() {
        this(InjectionPool.getFromInstance("$TreeDecoratorTypes"));
    }

    public TreeDecoratorTypeFactory(TemporalRegister<TreeDecoratorType<?>> treeDecoratorTypes) {
        super(treeDecoratorTypes);
    }

    public <T extends TreeDecorator> DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new TreeDecoratorType<>(codec));
    }
}