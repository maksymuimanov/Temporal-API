package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ChileanSpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateChileanSpanish;

public class TranslateChileanSpanishStrategy extends TranslationStrategy<TranslateChileanSpanish> {
    public TranslateChileanSpanishStrategy() {
        super(ChileanSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateChileanSpanish> getAnnotationClass() {
        return TranslateChileanSpanish.class;
    }
}
