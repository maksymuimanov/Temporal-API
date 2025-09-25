package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.PointOfInterestTypeTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddPointOfInterestTypeTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddPointOfInterestTypeTagStrategy implements FieldAnnotationStrategy<AddPointOfInterestTypeTag> {
    @Override
    public void execute(Field field, Object object, AddPointOfInterestTypeTag annotation) throws Exception {
        Holder<? extends PoiType> poiType = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(PointOfInterestTypeTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, poiType);
        }
    }

    @Override
    public Class<AddPointOfInterestTypeTag> getAnnotationClass() {
        return AddPointOfInterestTypeTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
