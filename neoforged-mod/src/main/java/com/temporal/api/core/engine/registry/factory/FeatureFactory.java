package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.Feature;

public class FeatureFactory extends AbstractObjectFactory<Feature<?>> {
    public FeatureFactory() {
        this(InjectionPool.getFromInstance("$Features"));
    }

    public FeatureFactory(TemporalRegister<Feature<?>> features) {
        super(features);
    }
}
