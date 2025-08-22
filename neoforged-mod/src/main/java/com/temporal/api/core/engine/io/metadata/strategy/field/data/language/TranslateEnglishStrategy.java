package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.event.data.language.provider.EnglishProvider;

public class TranslateEnglishStrategy extends TranslationStrategy<TranslateEnglish> {
    public TranslateEnglishStrategy() {
        super(EnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateEnglish> getAnnotationClass() {
        return TranslateEnglish.class;
    }
}
