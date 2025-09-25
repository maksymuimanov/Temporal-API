package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.BlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class BarrelBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation sideTexture = spec.getBlockLocation(ModelConstants.SIDE_SUFFIX);
        ResourceLocation bottomTexture = spec.getBlockLocation(ModelConstants.BOTTOM_SUFFIX);
        ResourceLocation topTexture = spec.getBlockLocation(ModelConstants.TOP_SUFFIX);
        provider.cubeBottomTop(itemPath, sideTexture, bottomTexture, topTexture);
    }
}
