package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HungarianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHungarian;

public class TranslateHungarianStrategy extends TranslationStrategy<TranslateHungarian> {
    public TranslateHungarianStrategy() {
        super(HungarianProvider.class);
    }

    @Override
    public Class<? extends TranslateHungarian> getAnnotationClass() {
        return TranslateHungarian.class;
    }
}
