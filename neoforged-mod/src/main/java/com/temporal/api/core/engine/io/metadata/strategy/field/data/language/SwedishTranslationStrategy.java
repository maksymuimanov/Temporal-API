package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.SwedishTranslation;
import com.temporal.api.core.event.data.language.provider.SwedishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SwedishTranslationStrategy extends TranslationStrategy {
    public SwedishTranslationStrategy() {
        super(SwedishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        SwedishTranslation translation = field.getDeclaredAnnotation(SwedishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SwedishTranslation.class;
    }
}
