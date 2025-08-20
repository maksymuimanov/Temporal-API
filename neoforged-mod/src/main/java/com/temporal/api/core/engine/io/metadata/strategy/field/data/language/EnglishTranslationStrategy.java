package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.EnglishTranslation;
import com.temporal.api.core.event.data.language.provider.EnglishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EnglishTranslationStrategy extends TranslationStrategy {
    public EnglishTranslationStrategy() {
        super(EnglishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        EnglishTranslation translation = field.getDeclaredAnnotation(EnglishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return EnglishTranslation.class;
    }
}
