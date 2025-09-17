package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.schedule.Schedule;
import net.minecraft.world.entity.schedule.ScheduleBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Consumer;

public class ScheduleFactory extends AbstractObjectFactory<Schedule> {
    public ScheduleFactory() {
        this(InjectionPool.getFromInstance("$Schedules"));
    }

    public ScheduleFactory(TemporalRegister<Schedule> register) {
        super(register);
    }

    public DeferredHolder<Schedule, Schedule> create(String name, Consumer<ScheduleBuilder> consumer) {
        return this.create(name, () -> {
            Schedule schedule = new Schedule();
            ScheduleBuilder scheduleBuilder = new ScheduleBuilder(schedule);
            consumer.accept(scheduleBuilder);
            return scheduleBuilder.build();
        });
    }
}
