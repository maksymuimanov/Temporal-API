package com.temporal.api.core.engine.io.metadata.strategy.type.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.RegisterAdvancement;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.advancement.AdvancementGenerationHolder;
import com.temporal.api.core.event.data.advancement.AdvancementStrategy;
import com.temporal.api.core.event.data.advancement.ApiAdvancementProvider;

import java.lang.reflect.Constructor;

public class RegisterAdvancementStrategy implements ClassAnnotationStrategy<RegisterAdvancement> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterAdvancement annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        AdvancementGenerationHolder advancementGenerationHolder = (AdvancementGenerationHolder) constructor.newInstance();
        if (AdvancementStrategy.class.equals(annotation.value())) {
            ApiAdvancementProvider.ADVANCEMENTS.add(advancementGenerationHolder);
        } else {
            Class<? extends AdvancementStrategy> strategyClass = annotation.value();
            AdvancementStrategy advancementStrategy = strategyClass.getDeclaredConstructor().newInstance();
            ApiAdvancementProvider.CUSTOM_ADVANCEMENTS.put(advancementGenerationHolder, advancementStrategy);
        }
    }

    @Override
    public Class<? extends RegisterAdvancement> getAnnotationClass() {
        return RegisterAdvancement.class;
    }
}
