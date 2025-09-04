package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.OccitanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateOccitan;

public class TranslateOccitanStrategy extends TranslationStrategy<TranslateOccitan> {
    public TranslateOccitanStrategy() {
        super(OccitanProvider.class);
    }

    @Override
    public Class<? extends TranslateOccitan> getAnnotationClass() {
        return TranslateOccitan.class;
    }
}
