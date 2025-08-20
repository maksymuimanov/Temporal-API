package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

public class TrimMaterialTransformer implements KeyTransformer<ResourceKey<TrimMaterial>> {
    @Override
    public String transform(ResourceKey<TrimMaterial> trimMaterial) {
        return this.transformResourceKey("trim_material", trimMaterial);
    }
}
