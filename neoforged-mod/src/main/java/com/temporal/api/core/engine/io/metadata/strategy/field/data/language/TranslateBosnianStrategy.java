package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateBosnian;
import com.temporal.api.core.event.data.language.provider.BosnianProvider;

public class TranslateBosnianStrategy extends TranslationStrategy<TranslateBosnian> {
    public TranslateBosnianStrategy() {
        super(BosnianProvider.class);
    }

    @Override
    public Class<? extends TranslateBosnian> getAnnotationClass() {
        return TranslateBosnian.class;
    }
}
