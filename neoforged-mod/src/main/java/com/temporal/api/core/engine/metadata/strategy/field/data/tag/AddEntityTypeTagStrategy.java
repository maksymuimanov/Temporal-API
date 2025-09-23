package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.EntityTypeTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddEntityTypeTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddEntityTypeTagStrategy implements FieldAnnotationStrategy<AddEntityTypeTag> {
    @Override
    public void execute(Field field, Object object, AddEntityTypeTag annotation) throws Exception {
        Holder<? extends EntityType<?>> entityType = (Holder<? extends EntityType<?>>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(EntityTypeTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, entityType);
        }
    }

    @Override
    public Class<AddEntityTypeTag> getAnnotationClass() {
        return AddEntityTypeTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
