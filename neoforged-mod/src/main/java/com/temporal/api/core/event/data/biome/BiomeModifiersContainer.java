package com.temporal.api.core.event.data.biome;

import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;

import java.util.HashMap;
import java.util.Map;

public final class BiomeModifiersContainer {
    public static final Map<String, ResourceKey<BiomeModifier>> BIOME_MODIFIERS = new HashMap<>();

    private BiomeModifiersContainer() {
    }
}
