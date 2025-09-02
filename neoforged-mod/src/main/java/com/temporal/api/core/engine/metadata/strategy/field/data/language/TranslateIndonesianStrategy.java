package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IndonesianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIndonesian;

public class TranslateIndonesianStrategy extends TranslationStrategy<TranslateIndonesian> {
    public TranslateIndonesianStrategy() {
        super(IndonesianProvider.class);
    }

    @Override
    public Class<? extends TranslateIndonesian> getAnnotationClass() {
        return TranslateIndonesian.class;
    }
}
