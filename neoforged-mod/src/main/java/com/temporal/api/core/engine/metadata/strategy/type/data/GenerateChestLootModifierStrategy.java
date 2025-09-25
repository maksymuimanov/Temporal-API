package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.modifier.ApiGlobalLootModifierProvider;
import com.temporal.api.core.engine.event.data.modifier.ChestModifierDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateChestLootModifier;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class GenerateChestLootModifierStrategy implements ClassAnnotationStrategy<GenerateChestLootModifier> {
    @Override
    public void execute(Class<?> clazz, Object object, GenerateChestLootModifier annotation) throws Exception {
        ChestModifierDescription description = (ChestModifierDescription) ReflectionUtils.createObject(clazz);
        ApiGlobalLootModifierProvider.CHEST_MODIFIER_DESCRIPTIONS.add(description);
    }

    @Override
    public Class<GenerateChestLootModifier> getAnnotationClass() {
        return GenerateChestLootModifier.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
