package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.DependantBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class ButtonBlockItemModelProviderStrategy implements ItemModelProviderStrategy<DependantBlockItemModelSpec> {
    @Override
    public void registerItemModel(DependantBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getDependencyBlockLocation();
        provider.buttonInventory(itemPath, texture);
    }
}
