package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.BlockItemModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;

public class WoodBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    public static final String WOOD = "wood";
    public static final String LOG = "log";

    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        String blockPath = spec.getBlockPath().replace(WOOD, LOG);
        ResourceLocation texture = ResourceUtils.parse(blockPath);
        provider.cubeColumn(itemPath, texture, texture);
    }
}
