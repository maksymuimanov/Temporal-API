package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.StructureTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddStructureTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddStructureTagStrategy implements FieldAnnotationStrategy<AddStructureTag> {
    @Override
    public void execute(Field field, Object object, AddStructureTag annotation) throws Exception {
        ResourceKey<Structure> structure = (ResourceKey<Structure>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(StructureTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, structure);
        }
    }

    @Override
    public Class<AddStructureTag> getAnnotationClass() {
        return AddStructureTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
