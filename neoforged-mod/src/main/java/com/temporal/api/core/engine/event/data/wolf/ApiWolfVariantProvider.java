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
    public static final Queue<WolfVariantDescriptionHolder> VARIANTS = new TemporalQueue<>();

    @Override
    public void addVariant(BootstrapContext<WolfVariant> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        VARIANTS.forEach(description -> {
            ResourceKey<WolfVariant> variant = description.variant();
            String name = "entity/wolf/" + ResourceUtils.getResourceId(variant);
            ResourceLocation defaultTexture = ResourceUtils.parse(name);
            ResourceLocation tamedTexture = ResourceUtils.parse(name + "_tame");
            ResourceLocation angryTexture = ResourceUtils.parse(name + "_angry");
            TagKey<Biome> spawnBiome = BiomeTagDynamicPreparer.BIOME_TAGS.get(description.biomeTag());
            context.register(variant, new WolfVariant(defaultTexture, tamedTexture, angryTexture, biomes.getOrThrow(spawnBiome)));
        });
    }

    public static void bootstrap(BootstrapContext<WolfVariant> context) {
        WolfVariantProvider provider = new ApiWolfVariantProvider();
        provider.addVariant(context);
    }
}
