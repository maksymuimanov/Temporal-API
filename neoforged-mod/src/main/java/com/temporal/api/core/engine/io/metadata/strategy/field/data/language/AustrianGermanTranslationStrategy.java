package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateAustrianGerman;
import com.temporal.api.core.event.data.language.provider.AustrianGermanProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AustrianGermanTranslationStrategy extends TranslationStrategy {
    public AustrianGermanTranslationStrategy() {
        super(AustrianGermanProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateAustrianGerman translation = field.getDeclaredAnnotation(TranslateAustrianGerman.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateAustrianGerman.class;
    }
}
