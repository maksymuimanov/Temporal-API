package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.world.BiomeModifier;

public class BiomeModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends BiomeModifier>> {
    public BiomeModifierSerializerFactory() {
        this(InjectionPool.getFromInstance("$BiomeModifierSerializers"));
    }

    public BiomeModifierSerializerFactory(TemporalRegister<MapCodec<? extends BiomeModifier>> register) {
        super(register);
    }
}
