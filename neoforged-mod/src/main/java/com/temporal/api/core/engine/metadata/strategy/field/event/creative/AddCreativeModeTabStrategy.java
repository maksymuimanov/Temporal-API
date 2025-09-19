package com.temporal.api.core.engine.metadata.strategy.field.event.creative;

import com.temporal.api.core.engine.event.handler.CreativeModeTabEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.creative.AddCreativeModeTab;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.constant.CreativeModeTabType;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.CreativeModeTabEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_CREATIVE)
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
    public Class<AddCreativeModeTab> getAnnotationClass() {
        return AddCreativeModeTab.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(CreativeModeTabEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
