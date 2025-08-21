package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateIndonesian;
import com.temporal.api.core.event.data.language.provider.IndonesianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class IndonesianTranslationStrategy extends TranslationStrategy {
    public IndonesianTranslationStrategy() {
        super(IndonesianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateIndonesian translation = field.getDeclaredAnnotation(TranslateIndonesian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateIndonesian.class;
    }
}
