package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GermanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGerman;

public class TranslateGermanStrategy extends TranslationStrategy<TranslateGerman> {
    public TranslateGermanStrategy() {
        super(GermanProvider.class);
    }

    @Override
    public Class<? extends TranslateGerman> getAnnotationClass() {
        return TranslateGerman.class;
    }
}
