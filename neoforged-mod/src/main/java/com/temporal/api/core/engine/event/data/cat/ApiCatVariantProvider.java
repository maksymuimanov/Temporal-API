package com.temporal.api.core.engine.event.data.cat;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.CatVariant;

import java.util.Queue;

public class ApiCatVariantProvider implements CatVariantProvider {
    public static final Queue<CatVariantDescription> VARIANTS = new TemporalQueue<>();
    public static final String ENTITY_CAT_PATH = "textures/entity/cat/%s.png";

    @Override
    public void addVariant(BootstrapContext<CatVariant> context) {
        VARIANTS.forEach(description -> {
            ResourceKey<CatVariant> variant = description.variant();
            String id = ResourceUtils.mapId(ResourceUtils.getResourceId(variant), ENTITY_CAT_PATH::formatted);
            ResourceLocation texture = ResourceUtils.parse(id);
            context.register(variant, new CatVariant(texture));
        });
    }

    public static void bootstrap(BootstrapContext<CatVariant> context) {
        CatVariantProvider provider = new ApiCatVariantProvider();
        provider.addVariant(context);
    }
}
