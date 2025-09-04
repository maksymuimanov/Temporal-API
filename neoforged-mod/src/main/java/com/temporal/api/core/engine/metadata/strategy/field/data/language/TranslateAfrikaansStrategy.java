package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AfrikaansProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAfrikaans;

public class TranslateAfrikaansStrategy extends TranslationStrategy<TranslateAfrikaans> {
    public TranslateAfrikaansStrategy() {
        super(AfrikaansProvider.class);
    }

    @Override
    public Class<? extends TranslateAfrikaans> getAnnotationClass() {
        return TranslateAfrikaans.class;
    }
}
