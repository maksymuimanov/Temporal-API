package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateDanish;
import com.temporal.api.core.event.data.language.provider.DanishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DanishTranslationStrategy extends TranslationStrategy {
    public DanishTranslationStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateDanish translation = field.getDeclaredAnnotation(TranslateDanish.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateDanish.class;
    }
}
