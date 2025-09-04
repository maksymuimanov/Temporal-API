package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ArabicProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateArabic;

public class TranslateArabicStrategy extends TranslationStrategy<TranslateArabic> {
    public TranslateArabicStrategy() {
        super(ArabicProvider.class);
    }

    @Override
    public Class<? extends TranslateArabic> getAnnotationClass() {
        return TranslateArabic.class;
    }
}
