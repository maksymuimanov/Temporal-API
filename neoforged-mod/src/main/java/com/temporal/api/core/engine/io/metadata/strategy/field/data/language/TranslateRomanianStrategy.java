package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateRomanian;
import com.temporal.api.core.event.data.language.provider.RomanianProvider;

public class TranslateRomanianStrategy extends TranslationStrategy<TranslateRomanian> {
    public TranslateRomanianStrategy() {
        super(RomanianProvider.class);
    }

    @Override
    public Class<? extends TranslateRomanian> getAnnotationClass() {
        return TranslateRomanian.class;
    }
}
