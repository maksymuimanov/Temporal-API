package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HindiProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHindi;

public class TranslateHindiStrategy extends TranslationStrategy<TranslateHindi> {
    public TranslateHindiStrategy() {
        super(HindiProvider.class);
    }

    @Override
    public Class<? extends TranslateHindi> getAnnotationClass() {
        return TranslateHindi.class;
    }
}
