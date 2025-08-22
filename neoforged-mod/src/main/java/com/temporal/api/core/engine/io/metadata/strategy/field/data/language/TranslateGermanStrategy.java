package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateGerman;
import com.temporal.api.core.event.data.language.provider.GermanProvider;

public class TranslateGermanStrategy extends TranslationStrategy<TranslateGerman> {
    public TranslateGermanStrategy() {
        super(GermanProvider.class);
    }

    @Override
    public Class<? extends TranslateGerman> getAnnotationClass() {
        return TranslateGerman.class;
    }
}
