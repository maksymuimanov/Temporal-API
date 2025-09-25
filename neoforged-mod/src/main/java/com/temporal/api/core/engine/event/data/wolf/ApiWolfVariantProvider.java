package com.temporal.api.core.engine.event.data.wolf;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.level.biome.Biome;

import java.util.Queue;

public class ApiWolfVariantProvider implements WolfVariantProvider {
    public static final Queue<WolfVariantDescription> VARIANTS = new TemporalQueue<>();
    public static final String ENTITY_WOLF_PATH = "entity/wolf/";
    public static final String TAME_SUFFIX = "_tame";
    public static final String ANGRY_SUFFIX = "_angry";

    @Override
    public void addVariant(BootstrapContext<WolfVariant> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        VARIANTS.forEach(description -> {
            ResourceKey<WolfVariant> variant = description.variant();
            String id = ResourceUtils.mapId(ResourceUtils.getResourceId(variant), ENTITY_WOLF_PATH::concat);
            ResourceLocation defaultTexture = ResourceUtils.parse(id);
            ResourceLocation tamedTexture = ResourceUtils.parse(id + TAME_SUFFIX);
            ResourceLocation angryTexture = ResourceUtils.parse(id + ANGRY_SUFFIX);
            TagKey<Biome> spawnBiome = BiomeTagDynamicPreparer.BIOME_TAGS.get(description.biomeTag());
            context.register(variant, new WolfVariant(defaultTexture, tamedTexture, angryTexture, biomes.getOrThrow(spawnBiome)));
        });
    }

    public static void bootstrap(BootstrapContext<WolfVariant> context) {
        WolfVariantProvider provider = new ApiWolfVariantProvider();
        provider.addVariant(context);
    }
}
