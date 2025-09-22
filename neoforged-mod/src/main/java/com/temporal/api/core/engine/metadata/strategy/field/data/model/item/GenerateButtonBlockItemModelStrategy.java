package com.temporal.api.core.engine.metadata.strategy.field.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.item.spec.DependantBlockItemModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.GenerateButtonBlockItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateButtonBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateButtonBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateButtonBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        DependantBlockItemModelSpec spec = new DependantBlockItemModelSpec(holder, annotation.parentBlockId());
        ItemModelDescriptionContainer.BUTTON_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateButtonBlockItemModel> getAnnotationClass() {
        return GenerateButtonBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
