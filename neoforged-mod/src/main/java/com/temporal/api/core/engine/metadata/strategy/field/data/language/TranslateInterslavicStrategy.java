package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.InterslavicProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateInterslavic;

public class TranslateInterslavicStrategy extends TranslationStrategy<TranslateInterslavic> {
    public TranslateInterslavicStrategy() {
        super(InterslavicProvider.class);
    }

    @Override
    public Class<? extends TranslateInterslavic> getAnnotationClass() {
        return TranslateInterslavic.class;
    }
}
