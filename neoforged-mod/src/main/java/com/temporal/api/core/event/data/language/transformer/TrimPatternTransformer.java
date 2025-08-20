package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

public class TrimPatternTransformer implements KeyTransformer<ResourceKey<TrimPattern>> {
    @Override
    public String transform(ResourceKey<TrimPattern> trimPattern) {
        return this.transformResourceKey("trim_pattern", trimPattern);
    }
}
