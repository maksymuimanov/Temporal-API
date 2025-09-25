package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.schedule.Activity;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ActivityFactory extends AbstractObjectFactory<Activity> {
    public ActivityFactory() {
        this(InjectionPool.getFromInstance("$Activities"));
    }

    public ActivityFactory(TemporalRegister<Activity> register) {
        super(register);
    }

    public DeferredHolder<Activity, Activity> create(String name) {
        return this.create(name, () -> new Activity(name));
    }
}
