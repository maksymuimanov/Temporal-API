package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ModelFile;

public class BlockFlatBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = provider.getItemPath(item, ApiBlockModelProvider.BLOCK_PREFIX);
        provider.getBuilder(provider.getItemPath(item))
                .parent(new ModelFile.UncheckedModelFile(ApiItemModelProvider.ITEM_GENERATED))
                .texture(ApiItemModelProvider.LAYER_0, ResourceUtils.parse(blockPath));
    }
}
