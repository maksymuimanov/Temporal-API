package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.RegisterAdvancementStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.RegisterEnchantmentEntityEffectStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.RegisterGlobalLootModifierStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.RegisterRecipeStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.RegisterTagContainerStrategy;
import com.temporal.api.core.util.IOUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class DataClassAnnotationProcessor implements AnnotationProcessor<ClassAnnotationStrategy> {
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new RegisterTagContainerStrategy(),
            new RegisterRecipeStrategy(),
            new RegisterGlobalLootModifierStrategy(),
            new RegisterAdvancementStrategy(),
            new RegisterEnchantmentEntityEffectStrategy(),
            new CustomAdvancementStrategy()
    ));

    @Override
    public AnnotationExecutor<ClassAnnotationStrategy> getExecutor() {
        return IOLayer.CLASS_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, ClassAnnotationStrategy> getStrategies() {
        return strategies;
    }
}
