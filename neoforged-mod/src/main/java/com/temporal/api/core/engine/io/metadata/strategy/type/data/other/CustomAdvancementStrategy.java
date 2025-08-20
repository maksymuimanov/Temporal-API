package com.temporal.api.core.engine.io.metadata.strategy.type.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.CustomAdvancement;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.advancement.AdvancementGenerationHolder;
import com.temporal.api.core.event.data.advancement.AdvancementStrategy;
import com.temporal.api.core.event.data.advancement.ApiAdvancementProvider;

import java.lang.annotation.Annotation;

public class CustomAdvancementStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        CustomAdvancement customAdvancement = clazz.getDeclaredAnnotation(CustomAdvancement.class);
        AdvancementGenerationHolder advancementGenerationHolder = (AdvancementGenerationHolder) clazz.getDeclaredConstructor().newInstance();
        Class<? extends AdvancementStrategy> strategyClass = customAdvancement.value();
        AdvancementStrategy advancementStrategy = strategyClass.getDeclaredConstructor().newInstance();
        ApiAdvancementProvider.CUSTOM_ADVANCEMENTS.put(advancementGenerationHolder, advancementStrategy);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CustomAdvancement.class;
    }
}
