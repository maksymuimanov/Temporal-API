package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.VietnameseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateVietnamese;

public class TranslateVietnameseStrategy extends TranslationStrategy<TranslateVietnamese> {
    public TranslateVietnameseStrategy() {
        super(VietnameseProvider.class);
    }

    @Override
    public Class<? extends TranslateVietnamese> getAnnotationClass() {
        return TranslateVietnamese.class;
    }
}
