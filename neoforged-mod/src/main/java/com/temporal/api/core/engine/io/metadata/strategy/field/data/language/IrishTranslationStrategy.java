package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateIrish;
import com.temporal.api.core.event.data.language.provider.IrishProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class IrishTranslationStrategy extends TranslationStrategy {
    public IrishTranslationStrategy() {
        super(IrishProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateIrish translation = field.getDeclaredAnnotation(TranslateIrish.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateIrish.class;
    }
}
