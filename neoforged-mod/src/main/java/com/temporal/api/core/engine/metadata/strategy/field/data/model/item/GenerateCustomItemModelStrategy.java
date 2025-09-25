package com.temporal.api.core.engine.metadata.strategy.field.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelContainer;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.CustomItemModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.GenerateCustomItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;
import java.util.List;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateCustomItemModelStrategy implements FieldAnnotationStrategy<GenerateCustomItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateCustomItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        List<String> additionalData = List.of(annotation.additionalData());
        CustomItemModelSpec spec = new CustomItemModelSpec(holder, additionalData);
        ItemModelProviderStrategy<CustomItemModelSpec> strategy = ReflectionUtils.createObject(annotation.strategy());
        ItemModelContainer.CUSTOM_MODELS.put(spec, strategy);
    }

    @Override
    public Class<GenerateCustomItemModel> getAnnotationClass() {
        return GenerateCustomItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
