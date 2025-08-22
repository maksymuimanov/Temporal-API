package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateIndonesian;
import com.temporal.api.core.event.data.language.provider.IndonesianProvider;

public class TranslateIndonesianStrategy extends TranslationStrategy<TranslateIndonesian> {
    public TranslateIndonesianStrategy() {
        super(IndonesianProvider.class);
    }

    @Override
    public Class<? extends TranslateIndonesian> getAnnotationClass() {
        return TranslateIndonesian.class;
    }
}
