package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslatePolish;
import com.temporal.api.core.event.data.language.provider.PolishProvider;

public class TranslatePolishStrategy extends TranslationStrategy<TranslatePolish> {
    public TranslatePolishStrategy() {
        super(PolishProvider.class);
    }

    @Override
    public Class<? extends TranslatePolish> getAnnotationClass() {
        return TranslatePolish.class;
    }
}
