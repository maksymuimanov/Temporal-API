package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.CzechTranslation;
import com.temporal.api.core.event.data.language.provider.CzechProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CzechTranslationStrategy extends TranslationStrategy {
    public CzechTranslationStrategy() {
        super(CzechProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        CzechTranslation translation = field.getDeclaredAnnotation(CzechTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CzechTranslation.class;
    }
}
