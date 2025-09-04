package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.YiddishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateYiddish;

public class TranslateYiddishStrategy extends TranslationStrategy<TranslateYiddish> {
    public TranslateYiddishStrategy() {
        super(YiddishProvider.class);
    }

    @Override
    public Class<? extends TranslateYiddish> getAnnotationClass() {
        return TranslateYiddish.class;
    }
}
