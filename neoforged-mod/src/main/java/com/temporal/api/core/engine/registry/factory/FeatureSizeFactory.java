package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSizeType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FeatureSizeFactory extends AbstractObjectFactory<FeatureSizeType<?>> {
    public FeatureSizeFactory() {
        this(InjectionPool.getFromInstance("$FeatureSizeTypes"));
    }

    public FeatureSizeFactory(TemporalRegister<FeatureSizeType<?>> register) {
        super(register);
    }

    public <T extends FeatureSize> DeferredHolder<FeatureSizeType<?>, FeatureSizeType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new FeatureSizeType<>(mapCodec));
    }
}
