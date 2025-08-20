package com.temporal.api.core.event.data.pack;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.banner.ApiBannerPatternProvider;
import com.temporal.api.core.event.data.biome.CompoundGenerationProcessFacade;
import com.temporal.api.core.event.data.damage.ApiDamageTypeProvider;
import com.temporal.api.core.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.event.data.music.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.event.data.trim.material.ApiTrimMaterialProvider;
import com.temporal.api.core.event.data.trim.pattern.ApiTrimPatternProvider;
import com.temporal.api.core.event.data.wolf.ApiWolfVariantProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ApiDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ApiTrimMaterialProvider::bootstrap)
            .add(Registries.TRIM_PATTERN, ApiTrimPatternProvider::bootstrap)
            .add(Registries.PAINTING_VARIANT, ApiPaintingVariantProvider::bootstrap)
            .add(Registries.DAMAGE_TYPE, ApiDamageTypeProvider::bootstrap)
            .add(Registries.WOLF_VARIANT, ApiWolfVariantProvider::bootstrap)
            .add(Registries.BANNER_PATTERN, ApiBannerPatternProvider::bootstrap)
            .add(Registries.ENCHANTMENT, ApiEnchantmentProvider::bootstrap)
            .add(Registries.JUKEBOX_SONG, ApiJukeboxSongProvider::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, CompoundGenerationProcessFacade::executeConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, CompoundGenerationProcessFacade::executePlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CompoundGenerationProcessFacade::executeBiomeModifiers);

    public ApiDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(IOLayer.NEO_MOD.getModId()));
    }
}
