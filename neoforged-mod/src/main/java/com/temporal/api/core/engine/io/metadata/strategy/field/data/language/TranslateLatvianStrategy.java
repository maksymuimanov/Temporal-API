package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateLatvian;
import com.temporal.api.core.event.data.language.provider.LatvianProvider;

public class TranslateLatvianStrategy extends TranslationStrategy<TranslateLatvian> {
    public TranslateLatvianStrategy() {
        super(LatvianProvider.class);
    }

    @Override
    public Class<? extends TranslateLatvian> getAnnotationClass() {
        return TranslateLatvian.class;
    }
}
