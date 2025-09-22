package com.temporal.api.core.engine.metadata.strategy.field.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelContainer;
import com.temporal.api.core.engine.event.data.model.item.spec.DependantBlockItemModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.GenerateSlabBlockItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateSlabBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateSlabBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateSlabBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        DependantBlockItemModelSpec spec = new DependantBlockItemModelSpec(holder, annotation.fullBlock());
        ItemModelContainer.SLAB_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateSlabBlockItemModel> getAnnotationClass() {
        return GenerateSlabBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
