package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BretonProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBreton;

public class TranslateBretonStrategy extends TranslationStrategy<TranslateBreton> {
    public TranslateBretonStrategy() {
        super(BretonProvider.class);
    }

    @Override
    public Class<? extends TranslateBreton> getAnnotationClass() {
        return TranslateBreton.class;
    }
}
