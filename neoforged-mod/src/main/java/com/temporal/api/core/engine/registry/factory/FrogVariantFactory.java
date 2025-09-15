package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.animal.FrogVariant;

public class FrogVariantFactory extends AbstractObjectFactory<FrogVariant> {
    public FrogVariantFactory() {
        this(InjectionPool.getFromInstance("$FrogVariants"));
    }

    public FrogVariantFactory(TemporalRegister<FrogVariant> register) {
        super(register);
    }
}
