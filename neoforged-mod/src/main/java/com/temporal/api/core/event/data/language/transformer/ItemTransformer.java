package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ItemTransformer implements KeyTransformer<ResourceKey<Item>> {
    @Override
    public String transform(ResourceKey<Item> item) {
        return this.transformResourceKey("item", item);
    }
}
