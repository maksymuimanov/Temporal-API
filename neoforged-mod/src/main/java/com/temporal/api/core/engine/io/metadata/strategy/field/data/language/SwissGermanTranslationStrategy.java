package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSwissGerman;
import com.temporal.api.core.event.data.language.provider.SwissGermanProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SwissGermanTranslationStrategy extends TranslationStrategy {
    public SwissGermanTranslationStrategy() {
        super(SwissGermanProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateSwissGerman translation = field.getDeclaredAnnotation(TranslateSwissGerman.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateSwissGerman.class;
    }
}
