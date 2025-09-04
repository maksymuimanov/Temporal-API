package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CanadianEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCanadianEnglish;

public class TranslateCanadianEnglishStrategy extends TranslationStrategy<TranslateCanadianEnglish> {
    public TranslateCanadianEnglishStrategy() {
        super(CanadianEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateCanadianEnglish> getAnnotationClass() {
        return TranslateCanadianEnglish.class;
    }
}
