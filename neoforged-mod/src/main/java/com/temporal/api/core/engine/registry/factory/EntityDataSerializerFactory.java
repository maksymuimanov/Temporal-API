package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.network.syncher.EntityDataSerializer;

public class EntityDataSerializerFactory extends AbstractObjectFactory<EntityDataSerializer<?>> {
    public EntityDataSerializerFactory() {
        this(InjectionPool.getFromInstance("$EntityDataSerializers"));
    }

    public EntityDataSerializerFactory(TemporalRegister<EntityDataSerializer<?>> register) {
        super(register);
    }
}
