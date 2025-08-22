package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEstonian;
import com.temporal.api.core.event.data.language.provider.EstonianProvider;

public class TranslateEstonianStrategy extends TranslationStrategy<TranslateEstonian> {
    public TranslateEstonianStrategy() {
        super(EstonianProvider.class);
    }

    @Override
    public Class<? extends TranslateEstonian> getAnnotationClass() {
        return TranslateEstonian.class;
    }
}
