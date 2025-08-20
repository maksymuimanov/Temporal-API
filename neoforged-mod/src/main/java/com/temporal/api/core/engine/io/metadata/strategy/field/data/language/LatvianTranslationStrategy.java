package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.LatvianTranslation;
import com.temporal.api.core.event.data.language.provider.LatvianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class LatvianTranslationStrategy extends TranslationStrategy {
    public LatvianTranslationStrategy() {
        super(LatvianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        LatvianTranslation translation = field.getDeclaredAnnotation(LatvianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return LatvianTranslation.class;
    }
}
