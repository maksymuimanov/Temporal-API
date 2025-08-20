package com.temporal.api.core.event.data.tag.biome;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ApiBiomeTagsProvider extends BiomeTagsProvider {
    public static final Map<String, List<ResourceKey<Biome>>> TAG_GENERATION_DESCRIPTIONS = new TemporalMap<>();

    public ApiBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        TAG_GENERATION_DESCRIPTIONS.forEach((tag, biomes) -> {
            if (BiomeTagDynamicPreparer.BIOME_TAGS.containsKey(tag)) {
                TagKey<Biome> tagKey = BiomeTagDynamicPreparer.BIOME_TAGS.get(tag);
                tag(tagKey).addAll(biomes);
            }
        });
    }
}
