package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.world.level.biome.Biome;

public class BiomeFactory extends AbstractObjectFactory<Biome> {
    public BiomeFactory() {
        this(InjectionPool.getFromInstance("$Biomes"));
    }

    public BiomeFactory(TemporalRegister<Biome> biomes) {
        super(biomes);
    }
}
