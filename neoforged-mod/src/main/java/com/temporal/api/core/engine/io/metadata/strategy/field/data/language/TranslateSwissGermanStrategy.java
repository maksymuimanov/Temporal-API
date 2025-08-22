package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSwissGerman;
import com.temporal.api.core.event.data.language.provider.SwissGermanProvider;

public class TranslateSwissGermanStrategy extends TranslationStrategy<TranslateSwissGerman> {
    public TranslateSwissGermanStrategy() {
        super(SwissGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateSwissGerman> getAnnotationClass() {
        return TranslateSwissGerman.class;
    }
}
