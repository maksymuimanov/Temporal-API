package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KazakhProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKazakh;

public class TranslateKazakhStrategy extends TranslationStrategy<TranslateKazakh> {
    public TranslateKazakhStrategy() {
        super(KazakhProvider.class);
    }

    @Override
    public Class<? extends TranslateKazakh> getAnnotationClass() {
        return TranslateKazakh.class;
    }
}
