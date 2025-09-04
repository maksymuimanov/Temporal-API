package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NewZealandEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNewZealandEnglish;

public class TranslateNewZealandEnglishStrategy extends TranslationStrategy<TranslateNewZealandEnglish> {
    public TranslateNewZealandEnglishStrategy() {
        super(NewZealandEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateNewZealandEnglish> getAnnotationClass() {
        return TranslateNewZealandEnglish.class;
    }
}
