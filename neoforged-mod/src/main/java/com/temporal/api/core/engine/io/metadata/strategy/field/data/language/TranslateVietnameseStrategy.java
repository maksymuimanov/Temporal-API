package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateVietnamese;
import com.temporal.api.core.event.data.language.provider.VietnameseProvider;

public class TranslateVietnameseStrategy extends TranslationStrategy<TranslateVietnamese> {
    public TranslateVietnameseStrategy() {
        super(VietnameseProvider.class);
    }

    @Override
    public Class<? extends TranslateVietnamese> getAnnotationClass() {
        return TranslateVietnamese.class;
    }
}
