package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEnglish;

public class TranslateEnglishStrategy extends TranslationStrategy<TranslateEnglish> {
    public TranslateEnglishStrategy() {
        super(EnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateEnglish> getAnnotationClass() {
        return TranslateEnglish.class;
    }
}
