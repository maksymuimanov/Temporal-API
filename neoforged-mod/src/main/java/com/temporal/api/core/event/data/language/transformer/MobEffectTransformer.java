package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;

public class MobEffectTransformer implements KeyTransformer<ResourceKey<MobEffect>> {
    @Override
    public String transform(ResourceKey<MobEffect> mobEffect) {
        return this.transformResourceKey("effect", mobEffect);
    }
}
