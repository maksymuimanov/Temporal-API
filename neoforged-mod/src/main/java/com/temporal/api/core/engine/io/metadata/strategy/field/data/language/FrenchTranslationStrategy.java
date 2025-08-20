package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.FrenchTranslation;
import com.temporal.api.core.event.data.language.provider.FrenchProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FrenchTranslationStrategy extends TranslationStrategy {
    public FrenchTranslationStrategy() {
        super(FrenchProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        FrenchTranslation translation = field.getDeclaredAnnotation(FrenchTranslation.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return FrenchTranslation.class;
    }
}
