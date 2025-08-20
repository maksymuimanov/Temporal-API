package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.defined.DefinedAdvancementStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.defined.DefinedEnchantmentEntityEffectStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.defined.DefinedGlobalLootModifierStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.defined.DefinedRecipeStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.other.CustomAdvancementStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.data.tag.TagContainerStrategy;
import com.temporal.api.core.util.IOUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class DataClassAnnotationProcessor implements AnnotationProcessor<ClassAnnotationStrategy> {
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new TagContainerStrategy(),
            new DefinedRecipeStrategy(),
            new DefinedGlobalLootModifierStrategy(),
            new DefinedAdvancementStrategy(),
            new DefinedEnchantmentEntityEffectStrategy(),
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
