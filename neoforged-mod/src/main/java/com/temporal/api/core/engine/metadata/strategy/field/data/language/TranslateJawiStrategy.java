package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.JawiProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateJawi;

public class TranslateJawiStrategy extends TranslationStrategy<TranslateJawi> {
    public TranslateJawiStrategy() {
        super(JawiProvider.class);
    }

    @Override
    public Class<? extends TranslateJawi> getAnnotationClass() {
        return TranslateJawi.class;
    }
}
