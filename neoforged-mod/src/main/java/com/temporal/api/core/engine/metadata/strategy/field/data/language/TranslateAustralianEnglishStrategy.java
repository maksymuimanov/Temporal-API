package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AustralianEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAustralianEnglish;

public class TranslateAustralianEnglishStrategy extends TranslationStrategy<TranslateAustralianEnglish> {
    public TranslateAustralianEnglishStrategy() {
        super(AustralianEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateAustralianEnglish> getAnnotationClass() {
        return TranslateAustralianEnglish.class;
    }
}
