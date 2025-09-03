package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AmericanEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;

public class TranslateAmericanEnglishStrategy extends TranslationStrategy<TranslateAmericanEnglish> {
    public TranslateAmericanEnglishStrategy() {
        super(AmericanEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateAmericanEnglish> getAnnotationClass() {
        return TranslateAmericanEnglish.class;
    }
}
