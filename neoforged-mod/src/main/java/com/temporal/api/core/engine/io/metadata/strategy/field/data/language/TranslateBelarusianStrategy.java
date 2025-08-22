package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateBelarusian;
import com.temporal.api.core.event.data.language.provider.BelarusianProvider;

public class TranslateBelarusianStrategy extends TranslationStrategy<TranslateBelarusian> {
    public TranslateBelarusianStrategy() {
        super(BelarusianProvider.class);
    }

    @Override
    public Class<? extends TranslateBelarusian> getAnnotationClass() {
        return TranslateBelarusian.class;
    }
}
