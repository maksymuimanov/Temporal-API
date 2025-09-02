package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EstonianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEstonian;

public class TranslateEstonianStrategy extends TranslationStrategy<TranslateEstonian> {
    public TranslateEstonianStrategy() {
        super(EstonianProvider.class);
    }

    @Override
    public Class<? extends TranslateEstonian> getAnnotationClass() {
        return TranslateEstonian.class;
    }
}
