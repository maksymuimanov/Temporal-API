package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.data.*;
import com.temporal.api.core.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class DataClassAnnotationProcessor implements AnnotationProcessor<ClassAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new RegisterTagContainerStrategy(),
            new RegisterRecipeStrategy(),
            new RegisterGlobalLootModifierStrategy(),
            new RegisterAdvancementStrategy(),
            new RegisterEnchantmentEntityEffectStrategy()
    ));

    @Override
    public AnnotationExecutor<ClassAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.CLASS_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
