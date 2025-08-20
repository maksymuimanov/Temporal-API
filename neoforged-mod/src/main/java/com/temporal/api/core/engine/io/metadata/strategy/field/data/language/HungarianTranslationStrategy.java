package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.HungarianTranslation;
import com.temporal.api.core.event.data.language.provider.HungarianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class HungarianTranslationStrategy extends TranslationStrategy {
    public HungarianTranslationStrategy() {
        super(HungarianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        HungarianTranslation translation = field.getDeclaredAnnotation(HungarianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return HungarianTranslation.class;
    }
}
