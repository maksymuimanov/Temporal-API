package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.ThaiTranslation;
import com.temporal.api.core.event.data.language.provider.ThaiProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ThaiTranslationStrategy extends TranslationStrategy {
    public ThaiTranslationStrategy() {
        super(ThaiProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        ThaiTranslation translation = field.getDeclaredAnnotation(ThaiTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return ThaiTranslation.class;
    }
}
