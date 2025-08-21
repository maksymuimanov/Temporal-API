package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateCroatian;
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
        TranslateCroatian translation = field.getDeclaredAnnotation(TranslateCroatian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateCroatian.class;
    }
}
