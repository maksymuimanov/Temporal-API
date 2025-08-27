package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BiomeFactory extends AbstractObjectFactory<Biome> {
    public BiomeFactory() {
        this(InjectionPool.getFromInstance("$Biomes"));
    }

    public BiomeFactory(DeferredRegister<Biome> biomes) {
        super(biomes);
    }
}
