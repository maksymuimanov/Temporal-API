package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateJapanese;
import com.temporal.api.core.event.data.language.provider.JapaneseProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class JapaneseTranslationStrategy extends TranslationStrategy {
    public JapaneseTranslationStrategy() {
        super(JapaneseProvider.class);
    }

    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Object o = field.get(object);
        TranslateJapanese translation = field.getDeclaredAnnotation(TranslateJapanese.class);
        this.putDynamicTranslation(translation.id(), translation.value(), o);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TranslateJapanese.class;
    }
}
