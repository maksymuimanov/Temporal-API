package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.Codec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

public final class DataMapTypeFactory {
    private DataMapTypeFactory() {
    }

    public static <K, V> DataMapType<K, V> create(String name, ResourceKey<Registry<K>> registryKey, Codec<V> codec, boolean mandatory) {
        return DataMapType.builder(ResourceUtils.createLocation(name), registryKey, codec)
                .synced(codec, mandatory)
                .build();
    }
}
