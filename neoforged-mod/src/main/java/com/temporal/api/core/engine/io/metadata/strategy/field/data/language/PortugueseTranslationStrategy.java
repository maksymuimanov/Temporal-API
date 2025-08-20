package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.PortugueseTranslation;
import com.temporal.api.core.event.data.language.provider.PortugueseProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PortugueseTranslationStrategy extends TranslationStrategy {
    public PortugueseTranslationStrategy() {
        super(PortugueseProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        PortugueseTranslation translation = field.getDeclaredAnnotation(PortugueseTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return PortugueseTranslation.class;
    }
}
