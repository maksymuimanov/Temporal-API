package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;

public class MobEffectTransformer implements KeyTransformer<ResourceKey<MobEffect>> {
    public static final String PREFIX = "effect";

    @Override
    public String transform(ResourceKey<MobEffect> mobEffect) {
        return this.transformResourceKey(PREFIX, mobEffect);
    }
}
