package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.BulgarianTranslation;
import com.temporal.api.core.event.data.language.provider.BulgarianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BulgarianTranslationStrategy extends TranslationStrategy {
    public BulgarianTranslationStrategy() {
        super(BulgarianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        BulgarianTranslation translation = field.getDeclaredAnnotation(BulgarianTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BulgarianTranslation.class;
    }
}
