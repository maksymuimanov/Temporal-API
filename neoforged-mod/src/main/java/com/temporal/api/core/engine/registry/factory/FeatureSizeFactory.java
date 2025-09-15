package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSizeType;

public class FeatureSizeFactory extends AbstractObjectFactory<FeatureSizeType<?>> {
    public FeatureSizeFactory() {
        this(InjectionPool.getFromInstance("$FeatureSizeTypes"));
    }

    public FeatureSizeFactory(TemporalRegister<FeatureSizeType<?>> register) {
        super(register);
    }
}
