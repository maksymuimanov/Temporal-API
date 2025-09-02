package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UkrainianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUkrainian;

public class TranslateUkrainianStrategy extends TranslationStrategy<TranslateUkrainian> {
    public TranslateUkrainianStrategy() {
        super(UkrainianProvider.class);
    }

    @Override
    public Class<? extends TranslateUkrainian> getAnnotationClass() {
        return TranslateUkrainian.class;
    }
}
