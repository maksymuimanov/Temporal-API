package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RomanianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRomanian;

public class TranslateRomanianStrategy extends TranslationStrategy<TranslateRomanian> {
    public TranslateRomanianStrategy() {
        super(RomanianProvider.class);
    }

    @Override
    public Class<? extends TranslateRomanian> getAnnotationClass() {
        return TranslateRomanian.class;
    }
}
