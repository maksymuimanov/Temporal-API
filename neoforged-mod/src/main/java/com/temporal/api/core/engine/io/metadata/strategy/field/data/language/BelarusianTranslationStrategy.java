package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.BelarusianTranslation;
import com.temporal.api.core.event.data.language.provider.BelarusianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BelarusianTranslationStrategy extends TranslationStrategy {
    public BelarusianTranslationStrategy() {
        super(BelarusianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        BelarusianTranslation translation = field.getDeclaredAnnotation(BelarusianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BelarusianTranslation.class;
    }
}
