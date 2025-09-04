package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ValencianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateValencian;

public class TranslateValencianStrategy extends TranslationStrategy<TranslateValencian> {
    public TranslateValencianStrategy() {
        super(ValencianProvider.class);
    }

    @Override
    public Class<? extends TranslateValencian> getAnnotationClass() {
        return TranslateValencian.class;
    }
}
