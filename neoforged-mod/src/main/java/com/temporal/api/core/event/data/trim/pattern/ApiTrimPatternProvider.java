package com.temporal.api.core.event.data.trim.pattern;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.event.data.json.AtlasTrimProvider;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;

import java.util.Map;
import java.util.Queue;

public class ApiTrimPatternProvider implements TrimPatternProvider {
    public static final Map<ResourceKey<TrimPattern>, TrimPatternDescriptionHolder> TRIM_PATTERNS = new TemporalMap<>();

    @Override
    public void registerTrimPatterns(BootstrapContext<TrimPattern> context) {
        TRIM_PATTERNS.forEach((trimPattern, description) -> {
            ResourceLocation location = trimPattern.location();
            Holder<Item> itemHolder = RegistryUtils.getItemById(description.itemId()).getDefaultInstance().getItemHolder();
            String descriptionId = Util.makeDescriptionId("trim_pattern", location);
            MutableComponent component = Component.translatable(descriptionId);
            context.register(trimPattern, new TrimPattern(location, itemHolder, component, description.decal()));
            Queue<ResourceLocation> patternLocations = AtlasTrimProvider.TRIM_INFO.getLeft();
            patternLocations.offer(location);
        });
    }

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        TrimPatternProvider provider = new ApiTrimPatternProvider();
        provider.registerTrimPatterns(context);
    }
}
