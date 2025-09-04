package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.YorubaProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateYoruba;

public class TranslateYorubaStrategy extends TranslationStrategy<TranslateYoruba> {
    public TranslateYorubaStrategy() {
        super(YorubaProvider.class);
    }

    @Override
    public Class<? extends TranslateYoruba> getAnnotationClass() {
        return TranslateYoruba.class;
    }
}
