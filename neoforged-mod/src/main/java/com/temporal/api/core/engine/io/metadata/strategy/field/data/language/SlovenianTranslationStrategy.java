package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.SlovenianTranslation;
import com.temporal.api.core.event.data.language.provider.SlovenianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SlovenianTranslationStrategy extends TranslationStrategy {
    public SlovenianTranslationStrategy() {
        super(SlovenianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        SlovenianTranslation translation = field.getDeclaredAnnotation(SlovenianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SlovenianTranslation.class;
    }
}
