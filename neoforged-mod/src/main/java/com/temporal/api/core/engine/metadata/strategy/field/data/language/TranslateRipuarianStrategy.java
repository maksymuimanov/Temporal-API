package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RipuarianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRipuarian;

public class TranslateRipuarianStrategy extends TranslationStrategy<TranslateRipuarian> {
    public TranslateRipuarianStrategy() {
        super(RipuarianProvider.class);
    }

    @Override
    public Class<? extends TranslateRipuarian> getAnnotationClass() {
        return TranslateRipuarian.class;
    }
}
