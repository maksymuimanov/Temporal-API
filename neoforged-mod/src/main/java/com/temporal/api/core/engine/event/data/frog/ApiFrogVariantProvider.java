package com.temporal.api.core.engine.event.data.frog;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;

import java.util.Queue;

public class ApiFrogVariantProvider implements FrogVariantProvider {
    public static final Queue<FrogVariantDescription> VARIANTS = new TemporalQueue<>();
    public static final String ENTITY_FROG_PATH = "textures/entity/frog";

    @Override
    public void addVariant(BootstrapContext<FrogVariant> context) {
        VARIANTS.forEach(description -> {
            ResourceKey<FrogVariant> variant = description.variant();
            String id = ResourceUtils.mapId(ResourceUtils.getResourceId(variant), ENTITY_FROG_PATH::concat);
            ResourceLocation texture = ResourceUtils.parse(id);
            context.register(variant, new FrogVariant(texture));
        });
    }

    public static void bootstrap(BootstrapContext<FrogVariant> context) {
        FrogVariantProvider provider = new ApiFrogVariantProvider();
        provider.addVariant(context);
    }
}
