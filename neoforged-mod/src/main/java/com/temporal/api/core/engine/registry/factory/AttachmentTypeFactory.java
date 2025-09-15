package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.Codec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class AttachmentTypeFactory extends AbstractObjectFactory<AttachmentType<?>> {
    public AttachmentTypeFactory() {
        this(InjectionPool.getFromInstance("$AttachmentTypes"));
    }

    public AttachmentTypeFactory(TemporalRegister<AttachmentType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<AttachmentType<?>, AttachmentType<T>> create(String name, Supplier<T> defaultValueSupplier, Codec<T> codec) {
        return this.create(name, () -> AttachmentType.builder(defaultValueSupplier)
                .serialize(codec)
                .build());
    }
}
