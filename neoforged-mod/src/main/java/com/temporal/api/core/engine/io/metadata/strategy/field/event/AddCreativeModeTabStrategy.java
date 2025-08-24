package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.CreativeModeTabEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.AddCreativeModeTab;
import com.temporal.api.core.engine.io.metadata.constant.CreativeModeTabType;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AddCreativeModeTabStrategy implements FieldAnnotationStrategy<AddCreativeModeTab> {
    @Override
    public void execute(Field field, Object object, AddCreativeModeTab annotation) throws Exception {
        Holder<? extends Item> registryObject = IOUtils.getItemHolder(field, object);
        CreativeModeTabType[] tabTypes = annotation.value();
        for (CreativeModeTabType tabType : tabTypes) {
            ResourceKey<CreativeModeTab> tab = tabType.getCreativeTab();
            boolean exists = CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT.containsKey(tab);
            if (exists) {
                CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT.get(tab).add(registryObject);
            } else {
                ArrayList<Holder<? extends Item>> items = new ArrayList<>();
                items.add(registryObject);
                CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT.put(tab, items);
            }
        }
    }

    @Override
    public Class<? extends AddCreativeModeTab> getAnnotationClass() {
        return AddCreativeModeTab.class;
    }
}
