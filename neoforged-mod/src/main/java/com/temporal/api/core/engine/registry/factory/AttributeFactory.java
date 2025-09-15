package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class AttributeFactory extends AbstractObjectFactory<Attribute> {
    public AttributeFactory() {
        this(InjectionPool.getFromInstance("$Attributes"));
    }

    public AttributeFactory(TemporalRegister<Attribute> register) {
        super(register);
    }
}
