package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.pot.ApiDecoratedPotPatternProvider;
import com.temporal.api.core.engine.event.data.pot.DecoratedPotPatternDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateDecoratedPotPattern;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateDecoratedPotPatternStrategy implements FieldAnnotationStrategy<GenerateDecoratedPotPattern> {
    @Override
    public void execute(Field field, Object object, GenerateDecoratedPotPattern annotation) throws Exception {
        ResourceKey<DecoratedPotPattern> patternResourceKey = (ResourceKey<DecoratedPotPattern>) field.get(object);
        ApiDecoratedPotPatternProvider.PATTERNS.add(new DecoratedPotPatternDescription(patternResourceKey));
    }

    @Override
    public Class<GenerateDecoratedPotPattern> getAnnotationClass() {
        return GenerateDecoratedPotPattern.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
