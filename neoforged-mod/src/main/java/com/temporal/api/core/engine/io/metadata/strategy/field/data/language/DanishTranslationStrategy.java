package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.DanishTranslation;
import com.temporal.api.core.event.data.language.provider.DanishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DanishTranslationStrategy extends TranslationStrategy {
    public DanishTranslationStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        DanishTranslation translation = field.getDeclaredAnnotation(DanishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return DanishTranslation.class;
    }
}
