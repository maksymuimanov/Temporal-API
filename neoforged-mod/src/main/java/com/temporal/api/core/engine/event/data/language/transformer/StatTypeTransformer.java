package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.stats.StatType;

public class StatTypeTransformer implements KeyTransformer<ResourceKey<StatType<?>>> {
    public static final String PREFIX = "stat_type";

    @Override
    public String transform(ResourceKey<StatType<?>> trimMaterial) {
        return this.transformResourceKey(PREFIX, trimMaterial);
    }
}
