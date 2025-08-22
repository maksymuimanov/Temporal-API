package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateUkrainian;
import com.temporal.api.core.event.data.language.provider.UkrainianProvider;

public class TranslateUkrainianStrategy extends TranslationStrategy<TranslateUkrainian> {
    public TranslateUkrainianStrategy() {
        super(UkrainianProvider.class);
    }

    @Override
    public Class<? extends TranslateUkrainian> getAnnotationClass() {
        return TranslateUkrainian.class;
    }
}
