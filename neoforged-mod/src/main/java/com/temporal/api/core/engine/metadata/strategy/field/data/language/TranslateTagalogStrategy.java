package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TagalogProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTagalog;

public class TranslateTagalogStrategy extends TranslationStrategy<TranslateTagalog> {
    public TranslateTagalogStrategy() {
        super(TagalogProvider.class);
    }

    @Override
    public Class<? extends TranslateTagalog> getAnnotationClass() {
        return TranslateTagalog.class;
    }
}
