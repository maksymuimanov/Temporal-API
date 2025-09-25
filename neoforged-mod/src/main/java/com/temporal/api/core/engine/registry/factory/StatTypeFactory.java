package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.StatType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StatTypeFactory extends AbstractObjectFactory<StatType<?>> {
    public StatTypeFactory() {
        this(InjectionPool.getFromInstance("$StatTypes"));
    }

    public StatTypeFactory(TemporalRegister<StatType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<StatType<?>, StatType<T>> create(String name, Registry<T> registry) {
        Component component = Component.translatable("stat_type." + ModContext.NEO_MOD.getModId() + "." + name);
        return this.create(name, () -> new StatType<>(registry, component));
    }
}
