package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateMandarin;
import com.temporal.api.core.event.data.language.provider.MandarinProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MandarinTranslationStrategy extends TranslationStrategy {
    public MandarinTranslationStrategy() {
        super(MandarinProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateMandarin translation = field.getDeclaredAnnotation(TranslateMandarin.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateMandarin.class;
    }
}
