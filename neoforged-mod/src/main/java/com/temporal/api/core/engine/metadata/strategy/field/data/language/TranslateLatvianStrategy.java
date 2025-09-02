package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatvianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatvian;

public class TranslateLatvianStrategy extends TranslationStrategy<TranslateLatvian> {
    public TranslateLatvianStrategy() {
        super(LatvianProvider.class);
    }

    @Override
    public Class<? extends TranslateLatvian> getAnnotationClass() {
        return TranslateLatvian.class;
    }
}
