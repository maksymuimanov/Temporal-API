package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class BarrelBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = provider.getItemPath(item, BlockModelSpec.BLOCK_PREFIX);
        provider.cubeBottomTop(provider.getItemPath(item), ResourceUtils.parse(blockPath + "_side"), ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top"));
    }
}
