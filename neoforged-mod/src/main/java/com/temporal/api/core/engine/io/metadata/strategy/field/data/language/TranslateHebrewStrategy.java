package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateHebrew;
import com.temporal.api.core.event.data.language.provider.HebrewProvider;

public class TranslateHebrewStrategy extends TranslationStrategy<TranslateHebrew> {
    public TranslateHebrewStrategy() {
        super(HebrewProvider.class);
    }

    @Override
    public Class<? extends TranslateHebrew> getAnnotationClass() {
        return TranslateHebrew.class;
    }
}
