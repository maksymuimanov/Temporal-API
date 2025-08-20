package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.PolishTranslation;
import com.temporal.api.core.event.data.language.provider.PolishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PolishTranslationStrategy extends TranslationStrategy {
    public PolishTranslationStrategy() {
        super(PolishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        PolishTranslation translation = field.getDeclaredAnnotation(PolishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return PolishTranslation.class;
    }
}
