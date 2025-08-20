package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.SpanishTranslation;
import com.temporal.api.core.event.data.language.provider.SpanishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SpanishTranslationStrategy extends TranslationStrategy {
    public SpanishTranslationStrategy() {
        super(SpanishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        SpanishTranslation translation = field.getDeclaredAnnotation(SpanishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SpanishTranslation.class;
    }
}
