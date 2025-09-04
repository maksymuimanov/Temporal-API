package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IdoProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIdo;

public class TranslateIdoStrategy extends TranslationStrategy<TranslateIdo> {
    public TranslateIdoStrategy() {
        super(IdoProvider.class);
    }

    @Override
    public Class<? extends TranslateIdo> getAnnotationClass() {
        return TranslateIdo.class;
    }
}
