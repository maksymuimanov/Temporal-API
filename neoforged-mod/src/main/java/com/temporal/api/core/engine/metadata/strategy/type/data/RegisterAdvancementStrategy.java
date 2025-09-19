package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.advancement.AdvancementDescription;
import com.temporal.api.core.engine.event.data.advancement.AdvancementStrategy;
import com.temporal.api.core.engine.event.data.advancement.ApiAdvancementProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterAdvancement;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventAnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.reflect.Constructor;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class RegisterAdvancementStrategy implements ClassAnnotationStrategy<RegisterAdvancement> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterAdvancement annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        AdvancementDescription advancementDescription = (AdvancementDescription) constructor.newInstance();
        if (AdvancementStrategy.class.equals(annotation.value())) {
            ApiAdvancementProvider.ADVANCEMENTS.add(advancementDescription);
        } else {
            Class<? extends AdvancementStrategy> strategyClass = annotation.value();
            AdvancementStrategy advancementStrategy = strategyClass.getDeclaredConstructor().newInstance();
            ApiAdvancementProvider.CUSTOM_ADVANCEMENTS.put(advancementDescription, advancementStrategy);
        }
    }

    @Override
    public Class<RegisterAdvancement> getAnnotationClass() {
        return RegisterAdvancement.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventAnnotationProcessor.NAME);
    }
}
