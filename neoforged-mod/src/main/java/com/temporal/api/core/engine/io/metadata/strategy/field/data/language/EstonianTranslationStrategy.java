package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.EstonianTranslation;
import com.temporal.api.core.event.data.language.provider.EstonianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EstonianTranslationStrategy extends TranslationStrategy {
    public EstonianTranslationStrategy() {
        super(EstonianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        EstonianTranslation translation = field.getDeclaredAnnotation(EstonianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return EstonianTranslation.class;
    }
}
