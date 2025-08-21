package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEstonian;
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
        TranslateEstonian translation = field.getDeclaredAnnotation(TranslateEstonian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateEstonian.class;
    }
}
