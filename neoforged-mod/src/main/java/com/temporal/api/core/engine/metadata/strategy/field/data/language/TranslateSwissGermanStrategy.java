package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SwissGermanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSwissGerman;

public class TranslateSwissGermanStrategy extends TranslationStrategy<TranslateSwissGerman> {
    public TranslateSwissGermanStrategy() {
        super(SwissGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateSwissGerman> getAnnotationClass() {
        return TranslateSwissGerman.class;
    }
}
