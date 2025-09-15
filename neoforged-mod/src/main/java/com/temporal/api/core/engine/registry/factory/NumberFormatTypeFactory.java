package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.network.chat.numbers.NumberFormatType;

public class NumberFormatTypeFactory extends AbstractObjectFactory<NumberFormatType<?>> {
    public NumberFormatTypeFactory() {
        this(InjectionPool.getFromInstance("$NumberFormatTypes"));
    }

    public NumberFormatTypeFactory(TemporalRegister<NumberFormatType<?>> register) {
        super(register);
    }
}
