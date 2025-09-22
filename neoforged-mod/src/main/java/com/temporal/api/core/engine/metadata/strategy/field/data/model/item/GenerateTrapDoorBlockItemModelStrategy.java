package com.temporal.api.core.engine.metadata.strategy.field.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.item.spec.TrapDoorBlockItemModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.GenerateTrapDoorBlockItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrapDoorBlockItemModelStrategy implements FieldAnnotationStrategy<GenerateTrapDoorBlockItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateTrapDoorBlockItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        TrapDoorBlockItemModelSpec spec = new TrapDoorBlockItemModelSpec(holder, annotation.orientable());
        ItemModelDescriptionContainer.TRAPDOOR_BLOCK_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateTrapDoorBlockItemModel> getAnnotationClass() {
        return GenerateTrapDoorBlockItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
