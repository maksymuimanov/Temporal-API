package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.animal.CatVariant;

public class CatVariantFactory extends AbstractObjectFactory<CatVariant> {
    public CatVariantFactory() {
        this(InjectionPool.getFromInstance("$CatVariants"));
    }

    public CatVariantFactory(TemporalRegister<CatVariant> register) {
        super(register);
    }
}
