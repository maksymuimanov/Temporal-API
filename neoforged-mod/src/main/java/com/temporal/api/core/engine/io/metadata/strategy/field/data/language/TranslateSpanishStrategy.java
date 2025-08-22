package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSpanish;
import com.temporal.api.core.event.data.language.provider.SpanishProvider;

public class TranslateSpanishStrategy extends TranslationStrategy<TranslateSpanish> {
    public TranslateSpanishStrategy() {
        super(SpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateSpanish> getAnnotationClass() {
        return TranslateSpanish.class;
    }
}
