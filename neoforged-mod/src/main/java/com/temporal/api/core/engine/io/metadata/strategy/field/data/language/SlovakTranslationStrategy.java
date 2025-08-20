package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.SlovakTranslation;
import com.temporal.api.core.event.data.language.provider.SlovakProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SlovakTranslationStrategy extends TranslationStrategy {
    public SlovakTranslationStrategy() {
        super(SlovakProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        SlovakTranslation translation = field.getDeclaredAnnotation(SlovakTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SlovakTranslation.class;
    }
}
