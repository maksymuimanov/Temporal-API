package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.CroatianTranslation;
import com.temporal.api.core.event.data.language.provider.CroatianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CroatianTranslationStrategy extends TranslationStrategy {
    public CroatianTranslationStrategy() {
        super(CroatianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        CroatianTranslation translation = field.getDeclaredAnnotation(CroatianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CroatianTranslation.class;
    }
}
