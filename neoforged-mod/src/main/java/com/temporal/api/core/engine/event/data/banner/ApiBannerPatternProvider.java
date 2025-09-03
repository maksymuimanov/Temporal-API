package com.temporal.api.core.engine.event.data.banner;

import com.temporal.api.core.collection.TemporalQueue;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.jetbrains.annotations.ApiStatus;

import java.util.Queue;

@ApiStatus.Experimental
public class ApiBannerPatternProvider implements BannerPatternProvider {
    public static final Queue<BannerPatternDescription> PATTERNS = new TemporalQueue<>();
    public static final String BANNER_TRANSLATION_PREFIX = "block.minecraft.banner.";

    @Override
    public void addVariant(BootstrapContext<BannerPattern> context) {
        PATTERNS.forEach(description -> {
            ResourceKey<BannerPattern> pattern = description.pattern();
            ResourceLocation location = pattern.location();
            context.register(pattern, new BannerPattern(location, BANNER_TRANSLATION_PREFIX + location.toShortLanguageKey()));
        });
    }

    public static void bootstrap(BootstrapContext<BannerPattern> context) {
        BannerPatternProvider provider = new ApiBannerPatternProvider();
        provider.addVariant(context);
    }
}
