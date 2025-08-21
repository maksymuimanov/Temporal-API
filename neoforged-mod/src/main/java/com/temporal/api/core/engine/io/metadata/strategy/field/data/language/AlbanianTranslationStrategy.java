package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateAlbanian;
import com.temporal.api.core.event.data.language.provider.AlbanianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AlbanianTranslationStrategy extends TranslationStrategy {
    public AlbanianTranslationStrategy() {
        super(AlbanianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateAlbanian translation = field.getDeclaredAnnotation(TranslateAlbanian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateAlbanian.class;
    }
}
