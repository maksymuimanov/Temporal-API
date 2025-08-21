package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateTurkish;
import com.temporal.api.core.event.data.language.provider.TurkishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TurkishTranslationStrategy extends TranslationStrategy {
    public TurkishTranslationStrategy() {
        super(TurkishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateTurkish translation = field.getDeclaredAnnotation(TranslateTurkish.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateTurkish.class;
    }
}
