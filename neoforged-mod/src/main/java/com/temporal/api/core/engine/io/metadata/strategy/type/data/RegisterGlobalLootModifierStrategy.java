package com.temporal.api.core.engine.io.metadata.strategy.type.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.RegisterGlobalLootModifier;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.modifier.ApiGlobalLootModifierProvider;
import com.temporal.api.core.event.data.modifier.ChestModifierDescription;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class RegisterGlobalLootModifierStrategy implements ClassAnnotationStrategy<RegisterGlobalLootModifier> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterGlobalLootModifier annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object globalLootModifier = constructor.newInstance();
        if (globalLootModifier instanceof ChestModifierDescription description) {
            ApiGlobalLootModifierProvider.CHEST_MODIFIER_DESCRIPTIONS.add(description);
        }
    }

    @Override
    public Class<? extends RegisterGlobalLootModifier> getAnnotationClass() {
        return RegisterGlobalLootModifier.class;
    }
}
