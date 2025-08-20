package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypeTransformer implements KeyTransformer<ResourceKey<DamageType>> {
    @Override
    public String transform(ResourceKey<DamageType> damageType) {
        return this.transformResourceKey("damage", damageType);
    }
}
