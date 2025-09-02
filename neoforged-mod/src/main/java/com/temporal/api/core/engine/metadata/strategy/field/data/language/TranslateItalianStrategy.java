package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ItalianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateItalian;

public class TranslateItalianStrategy extends TranslationStrategy<TranslateItalian> {
    public TranslateItalianStrategy() {
        super(ItalianProvider.class);
    }

    @Override
    public Class<? extends TranslateItalian> getAnnotationClass() {
        return TranslateItalian.class;
    }
}
