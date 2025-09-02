package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSpanish;

public class TranslateSpanishStrategy extends TranslationStrategy<TranslateSpanish> {
    public TranslateSpanishStrategy() {
        super(SpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateSpanish> getAnnotationClass() {
        return TranslateSpanish.class;
    }
}
