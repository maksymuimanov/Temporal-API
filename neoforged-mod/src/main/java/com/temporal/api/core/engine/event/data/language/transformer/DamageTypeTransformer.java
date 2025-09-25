package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypeTransformer implements KeyTransformer<ResourceKey<DamageType>> {
    public static final String PREFIX = "damage";

    @Override
    public String transform(ResourceKey<DamageType> damageType) {
        return this.transformResourceKey(PREFIX, damageType);
    }
}
