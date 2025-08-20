package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class CreativeModeTabTransformer implements KeyTransformer<ResourceKey<CreativeModeTab>> {
    @Override
    public String transform(ResourceKey<CreativeModeTab> creativeModeTabResourceKey) {
        return this.transformResourceKey("creativetab", creativeModeTabResourceKey);
    }
}
