package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.HebrewTranslation;
import com.temporal.api.core.event.data.language.provider.HebrewProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class HebrewTranslationStrategy extends TranslationStrategy {
    public HebrewTranslationStrategy() {
        super(HebrewProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        HebrewTranslation translation = field.getDeclaredAnnotation(HebrewTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return HebrewTranslation.class;
    }
}
