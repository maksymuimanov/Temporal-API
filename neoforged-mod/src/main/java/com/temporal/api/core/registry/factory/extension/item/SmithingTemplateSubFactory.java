package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.ItemFactory;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.neoforge.registries.DeferredItem;

public interface SmithingTemplateSubFactory {
    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, String location) {
        return this.createSmithingTemplate(name, new Item.Properties(), location);
    }

    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, Item.Properties properties, String location) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, (props) -> SmithingTemplateItem.createArmorTrimTemplate(ResourceUtils.parse(location)));
    }
}
