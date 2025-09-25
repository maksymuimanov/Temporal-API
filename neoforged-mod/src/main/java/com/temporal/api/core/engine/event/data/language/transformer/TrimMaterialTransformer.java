package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

public class TrimMaterialTransformer implements KeyTransformer<ResourceKey<TrimMaterial>> {
    public static final String PREFIX = "trim_material";

    @Override
    public String transform(ResourceKey<TrimMaterial> trimMaterial) {
        return this.transformResourceKey(PREFIX, trimMaterial);
    }
}
