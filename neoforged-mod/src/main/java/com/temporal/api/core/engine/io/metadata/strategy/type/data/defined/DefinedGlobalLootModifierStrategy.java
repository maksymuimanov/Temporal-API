package com.temporal.api.core.engine.io.metadata.strategy.type.data.defined;

import com.temporal.api.core.engine.io.metadata.annotation.data.defined.DefinedGlobalLootModifier;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.modifier.ApiGlobalLootModifierProvider;
import com.temporal.api.core.event.data.modifier.ChestModifierDescription;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class DefinedGlobalLootModifierStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object globalLootModifier = constructor.newInstance();
        if (globalLootModifier instanceof ChestModifierDescription description) {
            ApiGlobalLootModifierProvider.CHEST_MODIFIER_DESCRIPTIONS.add(description);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return DefinedGlobalLootModifier.class;
    }
}
