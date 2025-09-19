package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.CatVariantTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddCatVariantTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddCatVariantTagStrategy implements FieldAnnotationStrategy<AddCatVariantTag> {
    @Override
    public void execute(Field field, Object object, AddCatVariantTag annotation) throws Exception {
        ResourceKey<CatVariant> instrument = (ResourceKey<CatVariant>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(CatVariantTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, instrument);
        }
    }

    @Override
    public Class<AddCatVariantTag> getAnnotationClass() {
        return AddCatVariantTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
