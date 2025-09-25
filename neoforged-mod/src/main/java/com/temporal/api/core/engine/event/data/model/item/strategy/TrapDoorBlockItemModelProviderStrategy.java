package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.TrapDoorBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class TrapDoorBlockItemModelProviderStrategy implements ItemModelProviderStrategy<TrapDoorBlockItemModelSpec> {
    @Override
    public void registerItemModel(TrapDoorBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getBlockLocation();
        if (spec.isOrientable()) {
            provider.trapdoorOrientableBottom(itemPath, texture);
        } else {
            provider.trapdoorBottom(itemPath, texture);
        }
    }
}
