package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.CreativeModeTabEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.AddCreativeModeTab;
import com.temporal.api.core.engine.io.metadata.constant.CreativeModeTabType;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

public class AddCreativeModeTabStrategy implements FieldAnnotationStrategy<AddCreativeModeTab> {
    @Override
    public void execute(Field field, Object object, AddCreativeModeTab annotation) throws Exception {
        Holder<? extends Item> registryObject = ReflectionUtils.getItemHolder(field, object);
        CreativeModeTabType[] tabTypes = annotation.value();
        for (CreativeModeTabType tabType : tabTypes) {
            ResourceKey<CreativeModeTab> tab = tabType.getCreativeTab();
            MapUtils.putToListMap(CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT, tab, registryObject);
        }
    }

    @Override
    public Class<? extends AddCreativeModeTab> getAnnotationClass() {
        return AddCreativeModeTab.class;
    }
}
