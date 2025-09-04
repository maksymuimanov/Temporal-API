package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GeorgianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGeorgian;

public class TranslateGeorgianStrategy extends TranslationStrategy<TranslateGeorgian> {
    public TranslateGeorgianStrategy() {
        super(GeorgianProvider.class);
    }

    @Override
    public Class<? extends TranslateGeorgian> getAnnotationClass() {
        return TranslateGeorgian.class;
    }
}
