package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface KeyTransformer<T> {
    String transform(T t);

    default String transformResourceKey(String prefix, ResourceKey<?> key) {
        ResourceLocation location = key.location();
        return Util.makeDescriptionId(prefix, location);
    }
}
