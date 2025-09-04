package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

public class TrimPatternTransformer implements KeyTransformer<ResourceKey<TrimPattern>> {
    public static final String PREFIX = "trim_pattern";

    @Override
    public String transform(ResourceKey<TrimPattern> trimPattern) {
        return this.transformResourceKey(PREFIX, trimPattern);
    }
}
