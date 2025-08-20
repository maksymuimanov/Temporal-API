package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.KazakhTranslation;
import com.temporal.api.core.event.data.language.provider.KazakhProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class KazakhTranslationStrategy extends TranslationStrategy {
    public KazakhTranslationStrategy() {
        super(KazakhProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        KazakhTranslation translation = field.getDeclaredAnnotation(KazakhTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return KazakhTranslation.class;
    }
}
