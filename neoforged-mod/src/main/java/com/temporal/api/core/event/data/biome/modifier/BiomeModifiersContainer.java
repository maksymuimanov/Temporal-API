package com.temporal.api.core.event.data.biome.modifier;

import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;

import java.util.HashMap;
import java.util.Map;

public final class BiomeModifiersContainer {
    public static final Map<String, ResourceKey<BiomeModifier>> BIOME_MODIFIERS = new HashMap<>();

    private BiomeModifiersContainer() {
    }
}
