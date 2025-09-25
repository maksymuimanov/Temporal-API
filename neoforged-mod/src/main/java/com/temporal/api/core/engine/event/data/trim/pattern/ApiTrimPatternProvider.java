package com.temporal.api.core.engine.event.data.trim.pattern;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.event.data.file.AtlasArmorTrimProvider;
import com.temporal.api.core.engine.event.data.language.transformer.TrimPatternTransformer;
import com.temporal.api.core.util.RegistryUtils;
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

public class ApiTrimPatternProvider implements TrimPatternProvider {
    public static final Map<ResourceKey<TrimPattern>, TrimPatternDescription> TRIM_PATTERNS = new TemporalMap<>();

    @Override
    public void registerTrimPatterns(BootstrapContext<TrimPattern> context) {
        TRIM_PATTERNS.forEach((trimPattern, description) -> {
            ResourceLocation location = trimPattern.location();
            Holder<Item> itemHolder = RegistryUtils.getItem(description.itemId()).getDefaultInstance().getItemHolder();
            String descriptionId = Util.makeDescriptionId(TrimPatternTransformer.PREFIX, location);
            MutableComponent component = Component.translatable(descriptionId);
            context.register(trimPattern, new TrimPattern(location, itemHolder, component, description.decal()));
            AtlasArmorTrimProvider.TRIM_PATTERNS_LOCATIONS.offer(location);
        });
    }

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        TrimPatternProvider provider = new ApiTrimPatternProvider();
        provider.registerTrimPatterns(context);
    }
}
