package com.temporal.api.core.util.biome;

import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class BiomeModifiersUtils {
    private BiomeModifiersUtils() {
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceUtils.createKey(NeoForgeRegistries.Keys.BIOME_MODIFIERS, name);
    }

    public static void register(BootstrapContext<BiomeModifier> context, ResourceKey<BiomeModifier> biomeModifierKey, HolderSet.Named<Biome> foundBiomes, HolderSet.Direct<PlacedFeature> placedFeature, GenerationStep.Decoration step) {
        context.register(biomeModifierKey, new BiomeModifiers.AddFeaturesBiomeModifier(foundBiomes, placedFeature, step));
    }
}
