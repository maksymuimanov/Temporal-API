package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.neoforge.registries.DeferredItem;

public interface SmithingTemplateSubFactory {
    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, String patternName) {
        return this.createSmithingTemplate(name, new Item.Properties(), patternName);
    }

    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, Item.Properties properties, String patternName) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, (props) -> SmithingTemplateItem.createArmorTrimTemplate(ResourceUtils.parse(patternName)));
    }
}
