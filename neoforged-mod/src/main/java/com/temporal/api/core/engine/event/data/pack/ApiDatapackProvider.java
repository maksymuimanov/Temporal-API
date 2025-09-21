package com.temporal.api.core.engine.event.data.pack;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.banner.ApiBannerPatternProvider;
import com.temporal.api.core.engine.event.data.biome.CompoundGenerationDefinitionFacade;
import com.temporal.api.core.engine.event.data.damage.ApiDamageTypeProvider;
import com.temporal.api.core.engine.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.engine.event.data.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.engine.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.engine.event.data.trim.material.ApiTrimMaterialProvider;
import com.temporal.api.core.engine.event.data.trim.pattern.ApiTrimPatternProvider;
import com.temporal.api.core.engine.event.data.wolf.ApiWolfVariantProvider;
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
//            .add(Registries.FROG_VARIANT, ApiFrogVariantProvider::bootstrap) FIXME
//            .add(Registries.CAT_VARIANT, ApiCatVariantProvider::bootstrap) FIXME
            .add(Registries.BANNER_PATTERN, ApiBannerPatternProvider::bootstrap)
//            .add(Registries.DECORATED_POT_PATTERN, ApiDecoratedPotPatternProvider::bootstrap) FIXME
            .add(Registries.JUKEBOX_SONG, ApiJukeboxSongProvider::bootstrap)
//            .add(Registries.INSTRUMENT, ApiInstrumentProvider::bootstrap) FIXME
            .add(Registries.ENCHANTMENT, ApiEnchantmentProvider::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, CompoundGenerationDefinitionFacade::executeConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, CompoundGenerationDefinitionFacade::executePlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CompoundGenerationDefinitionFacade::executeBiomeModifiers);

    public ApiDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ModContext.NEO_MOD.getModId()));
    }
}
