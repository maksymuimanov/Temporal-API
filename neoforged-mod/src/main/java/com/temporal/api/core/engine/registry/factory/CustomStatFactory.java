package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CustomStatFactory extends AbstractObjectFactory<ResourceLocation> {
    public CustomStatFactory() {
        this(InjectionPool.getFromInstance("$CustomStats"));
    }

    public CustomStatFactory(TemporalRegister<ResourceLocation> register) {
        super(register);
    }

    public DeferredHolder<ResourceLocation, ResourceLocation> create(String name) {
        ResourceLocation resourcelocation = ResourceUtils.parse(name);
        return this.create(name, () -> resourcelocation);
    }
}
