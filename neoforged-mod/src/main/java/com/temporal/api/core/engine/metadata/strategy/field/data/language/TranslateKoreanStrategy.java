package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KoreanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKorean;

public class TranslateKoreanStrategy extends TranslationStrategy<TranslateKorean> {
    public TranslateKoreanStrategy() {
        super(KoreanProvider.class);
    }

    @Override
    public Class<? extends TranslateKorean> getAnnotationClass() {
        return TranslateKorean.class;
    }
}
