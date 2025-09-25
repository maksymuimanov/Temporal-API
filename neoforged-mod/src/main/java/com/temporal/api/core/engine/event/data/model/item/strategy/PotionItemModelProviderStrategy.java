package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class PotionItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    public static final String MODEL_PARENT = "item/potion";
    public static final String LAYER_0_TEXTURE = "item/potion_overlay";

    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getLocation();
        provider.withExistingParent(itemPath, MODEL_PARENT)
                .texture(ModelConstants.LAYER_0, provider.mcLoc(LAYER_0_TEXTURE))
                .texture(ModelConstants.LAYER_1, texture);
    }
}
