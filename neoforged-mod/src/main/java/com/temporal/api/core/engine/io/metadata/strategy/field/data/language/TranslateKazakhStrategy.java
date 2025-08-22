package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateKazakh;
import com.temporal.api.core.event.data.language.provider.KazakhProvider;

public class TranslateKazakhStrategy extends TranslationStrategy<TranslateKazakh> {
    public TranslateKazakhStrategy() {
        super(KazakhProvider.class);
    }

    @Override
    public Class<? extends TranslateKazakh> getAnnotationClass() {
        return TranslateKazakh.class;
    }
}
