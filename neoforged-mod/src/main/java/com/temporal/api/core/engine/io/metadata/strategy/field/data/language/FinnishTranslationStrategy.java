package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.FinnishTranslation;
import com.temporal.api.core.event.data.language.provider.FinnishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FinnishTranslationStrategy extends TranslationStrategy {
    public FinnishTranslationStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        FinnishTranslation translation = field.getDeclaredAnnotation(FinnishTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return FinnishTranslation.class;
    }
}
