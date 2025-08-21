package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateRomanian;
import com.temporal.api.core.event.data.language.provider.RomanianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RomanianTranslationStrategy extends TranslationStrategy {
    public RomanianTranslationStrategy() {
        super(RomanianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateRomanian translation = field.getDeclaredAnnotation(TranslateRomanian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateRomanian.class;
    }
}
