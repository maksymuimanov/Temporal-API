package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LowGermanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLowGerman;

public class TranslateLowGermanStrategy extends TranslationStrategy<TranslateLowGerman> {
    public TranslateLowGermanStrategy() {
        super(LowGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateLowGerman> getAnnotationClass() {
        return TranslateLowGerman.class;
    }
}
