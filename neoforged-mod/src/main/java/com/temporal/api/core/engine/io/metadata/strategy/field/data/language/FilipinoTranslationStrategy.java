package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateFilipino;
import com.temporal.api.core.event.data.language.provider.FilipinoProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FilipinoTranslationStrategy extends TranslationStrategy {
    public FilipinoTranslationStrategy() {
        super(FilipinoProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateFilipino translation = field.getDeclaredAnnotation(TranslateFilipino.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateFilipino.class;
    }
}
