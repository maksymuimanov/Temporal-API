package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;

public class CommandArgumentTypeFactory extends AbstractObjectFactory<ArgumentTypeInfo<?, ?>> {
    public CommandArgumentTypeFactory() {
        this(InjectionPool.getFromInstance("$CommandArgumentTypes"));
    }

    public CommandArgumentTypeFactory(TemporalRegister<ArgumentTypeInfo<?, ?>> register) {
        super(register);
    }
}
