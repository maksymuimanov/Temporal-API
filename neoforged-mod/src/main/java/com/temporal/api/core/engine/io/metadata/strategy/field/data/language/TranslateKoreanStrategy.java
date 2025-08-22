package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateKorean;
import com.temporal.api.core.event.data.language.provider.KoreanProvider;

public class TranslateKoreanStrategy extends TranslationStrategy<TranslateKorean> {
    public TranslateKoreanStrategy() {
        super(KoreanProvider.class);
    }

    @Override
    public Class<? extends TranslateKorean> getAnnotationClass() {
        return TranslateKorean.class;
    }
}
