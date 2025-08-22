package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateItalian;
import com.temporal.api.core.event.data.language.provider.ItalianProvider;

public class TranslateItalianStrategy extends TranslationStrategy<TranslateItalian> {
    public TranslateItalianStrategy() {
        super(ItalianProvider.class);
    }

    @Override
    public Class<? extends TranslateItalian> getAnnotationClass() {
        return TranslateItalian.class;
    }
}
