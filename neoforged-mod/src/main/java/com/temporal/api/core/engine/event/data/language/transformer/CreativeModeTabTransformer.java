package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class CreativeModeTabTransformer implements KeyTransformer<ResourceKey<CreativeModeTab>> {
    public static final String PREFIX = "creativetab";

    @Override
    public String transform(ResourceKey<CreativeModeTab> creativeModeTabResourceKey) {
        return this.transformResourceKey(PREFIX, creativeModeTabResourceKey);
    }
}
