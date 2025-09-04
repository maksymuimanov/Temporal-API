package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.WelshProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateWelsh;

public class TranslateWelshStrategy extends TranslationStrategy<TranslateWelsh> {
    public TranslateWelshStrategy() {
        super(WelshProvider.class);
    }

    @Override
    public Class<? extends TranslateWelsh> getAnnotationClass() {
        return TranslateWelsh.class;
    }
}
