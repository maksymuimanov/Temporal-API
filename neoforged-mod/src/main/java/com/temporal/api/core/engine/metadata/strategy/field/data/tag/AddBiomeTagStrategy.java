package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.BiomeTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBiomeTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddBiomeTagStrategy implements FieldAnnotationStrategy<AddBiomeTag> {
    @Override
    public void execute(Field field, Object object, AddBiomeTag annotation) throws Exception {
        ResourceKey<Biome> biome = (ResourceKey<Biome>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(BiomeTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, biome);
        }
    }

    @Override
    public Class<AddBiomeTag> getAnnotationClass() {
        return AddBiomeTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
