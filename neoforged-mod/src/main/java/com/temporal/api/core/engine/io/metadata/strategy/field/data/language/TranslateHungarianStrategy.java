package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateHungarian;
import com.temporal.api.core.event.data.language.provider.HungarianProvider;

public class TranslateHungarianStrategy extends TranslationStrategy<TranslateHungarian> {
    public TranslateHungarianStrategy() {
        super(HungarianProvider.class);
    }

    @Override
    public Class<? extends TranslateHungarian> getAnnotationClass() {
        return TranslateHungarian.class;
    }
}
