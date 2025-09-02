package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BelarusianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBelarusian;

public class TranslateBelarusianStrategy extends TranslationStrategy<TranslateBelarusian> {
    public TranslateBelarusianStrategy() {
        super(BelarusianProvider.class);
    }

    @Override
    public Class<? extends TranslateBelarusian> getAnnotationClass() {
        return TranslateBelarusian.class;
    }
}
