package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class BlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = RegistryUtils.getIdFromRegistry(BuiltInRegistries.ITEM, item, "block");
        provider.cubeAll(blockPath, ResourceLocation.parse(blockPath));
    }
}
