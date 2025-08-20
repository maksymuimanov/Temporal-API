package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.IcelandicTranslation;
import com.temporal.api.core.event.data.language.provider.IcelandicProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class IcelandicTranslationStrategy extends TranslationStrategy {
    public IcelandicTranslationStrategy() {
        super(IcelandicProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        IcelandicTranslation translation = field.getDeclaredAnnotation(IcelandicTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return IcelandicTranslation.class;
    }
}
