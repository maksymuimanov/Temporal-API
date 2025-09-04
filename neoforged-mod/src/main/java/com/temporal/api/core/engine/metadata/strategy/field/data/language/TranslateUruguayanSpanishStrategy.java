package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UruguayanSpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUruguayanSpanish;

public class TranslateUruguayanSpanishStrategy extends TranslationStrategy<TranslateUruguayanSpanish> {
    public TranslateUruguayanSpanishStrategy() {
        super(UruguayanSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateUruguayanSpanish> getAnnotationClass() {
        return TranslateUruguayanSpanish.class;
    }
}
