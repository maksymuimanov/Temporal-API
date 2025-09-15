package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.resources.ResourceLocation;

public class CustomStatFactory extends AbstractObjectFactory<ResourceLocation> {
    public CustomStatFactory() {
        this(InjectionPool.getFromInstance("$CustomStats"));
    }

    public CustomStatFactory(TemporalRegister<ResourceLocation> register) {
        super(register);
    }
}
