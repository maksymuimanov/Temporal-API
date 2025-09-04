package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ArgentianSpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateArgentianSpanish;

public class TranslateArgentianSpanishStrategy extends TranslationStrategy<TranslateArgentianSpanish> {
    public TranslateArgentianSpanishStrategy() {
        super(ArgentianSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateArgentianSpanish> getAnnotationClass() {
        return TranslateArgentianSpanish.class;
    }
}
