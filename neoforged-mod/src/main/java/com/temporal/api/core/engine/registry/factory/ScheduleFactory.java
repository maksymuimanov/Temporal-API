package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.schedule.Schedule;

public class ScheduleFactory extends AbstractObjectFactory<Schedule> {
    public ScheduleFactory() {
        this(InjectionPool.getFromInstance("$Schedules"));
    }

    public ScheduleFactory(TemporalRegister<Schedule> register) {
        super(register);
    }
}
