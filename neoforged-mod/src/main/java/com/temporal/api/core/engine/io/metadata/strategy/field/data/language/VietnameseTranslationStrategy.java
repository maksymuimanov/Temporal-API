package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateVietnamese;
import com.temporal.api.core.event.data.language.provider.VietnameseProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class VietnameseTranslationStrategy extends TranslationStrategy {
    public VietnameseTranslationStrategy() {
        super(VietnameseProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateVietnamese translation = field.getDeclaredAnnotation(TranslateVietnamese.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateVietnamese.class;
    }
}
