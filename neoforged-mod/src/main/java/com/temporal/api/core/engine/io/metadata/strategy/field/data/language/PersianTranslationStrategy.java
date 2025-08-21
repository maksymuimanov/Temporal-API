package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslatePersian;
import com.temporal.api.core.event.data.language.provider.PersianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PersianTranslationStrategy extends TranslationStrategy {
    public PersianTranslationStrategy() {
        super(PersianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslatePersian translation = field.getDeclaredAnnotation(TranslatePersian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslatePersian.class;
    }
}
