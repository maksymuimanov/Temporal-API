package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateBosnian;
import com.temporal.api.core.event.data.language.provider.BosnianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BosnianTranslationStrategy extends TranslationStrategy {
    public BosnianTranslationStrategy() {
        super(BosnianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateBosnian translation = field.getDeclaredAnnotation(TranslateBosnian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateBosnian.class;
    }
}
