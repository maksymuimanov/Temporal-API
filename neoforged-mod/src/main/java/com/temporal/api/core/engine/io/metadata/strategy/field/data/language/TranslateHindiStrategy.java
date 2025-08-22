package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateHindi;
import com.temporal.api.core.event.data.language.provider.HindiProvider;

public class TranslateHindiStrategy extends TranslationStrategy<TranslateHindi> {
    public TranslateHindiStrategy() {
        super(HindiProvider.class);
    }

    @Override
    public Class<? extends TranslateHindi> getAnnotationClass() {
        return TranslateHindi.class;
    }
}
