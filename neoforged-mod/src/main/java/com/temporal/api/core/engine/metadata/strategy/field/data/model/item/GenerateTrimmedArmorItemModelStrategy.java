package com.temporal.api.core.engine.metadata.strategy.field.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.GenerateTrimmedArmorItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrimmedArmorItemModelStrategy implements FieldAnnotationStrategy<GenerateTrimmedArmorItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateTrimmedArmorItemModel annotation) throws Exception {
        Holder<? extends Item> holder = ReflectionUtils.getItemHolder(field, object);
        ItemModelSpec spec = new ItemModelSpec(holder);
        ItemModelDescriptionContainer.TRIMMED_ARMOR_ITEMS.add(spec);
    }

    @Override
    public Class<GenerateTrimmedArmorItemModel> getAnnotationClass() {
        return GenerateTrimmedArmorItemModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
