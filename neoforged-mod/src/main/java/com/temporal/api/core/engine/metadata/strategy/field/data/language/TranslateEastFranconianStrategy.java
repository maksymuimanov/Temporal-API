package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EastFranconianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEastFranconian;

public class TranslateEastFranconianStrategy extends TranslationStrategy<TranslateEastFranconian> {
    public TranslateEastFranconianStrategy() {
        super(EastFranconianProvider.class);
    }

    @Override
    public Class<? extends TranslateEastFranconian> getAnnotationClass() {
        return TranslateEastFranconian.class;
    }
}
