package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BiomeFactory extends AbstractObjectFactory<Biome> {
    private final DeferredRegister<Biome> biomes;

    public BiomeFactory() {
        this(InjectionPool.getFromInstance("$Biomes"));
    }

    public BiomeFactory(DeferredRegister<Biome> biomes) {
        this.biomes = biomes;
    }

    @Override
    public DeferredRegister<Biome> getRegistry() {
        return biomes;
    }
}
