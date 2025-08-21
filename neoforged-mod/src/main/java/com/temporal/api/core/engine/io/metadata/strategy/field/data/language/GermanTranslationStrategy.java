package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateGerman;
import com.temporal.api.core.event.data.language.provider.GermanProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GermanTranslationStrategy extends TranslationStrategy {
    public GermanTranslationStrategy() {
        super(GermanProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateGerman translation = field.getDeclaredAnnotation(TranslateGerman.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateGerman.class;
    }
}
