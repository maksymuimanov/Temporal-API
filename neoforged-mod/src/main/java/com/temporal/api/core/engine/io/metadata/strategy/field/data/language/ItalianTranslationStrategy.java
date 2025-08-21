package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateItalian;
import com.temporal.api.core.event.data.language.provider.ItalianProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ItalianTranslationStrategy extends TranslationStrategy {
    public ItalianTranslationStrategy() {
        super(ItalianProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateItalian translation = field.getDeclaredAnnotation(TranslateItalian.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateItalian.class;
    }
}
