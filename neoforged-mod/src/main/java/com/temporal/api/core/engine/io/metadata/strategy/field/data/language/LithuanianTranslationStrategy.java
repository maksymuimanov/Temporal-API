package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateLithuanian;
import com.temporal.api.core.event.data.language.provider.LithuanianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class LithuanianTranslationStrategy extends TranslationStrategy {
    public LithuanianTranslationStrategy() {
        super(LithuanianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateLithuanian translation = field.getDeclaredAnnotation(TranslateLithuanian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateLithuanian.class;
    }
}
