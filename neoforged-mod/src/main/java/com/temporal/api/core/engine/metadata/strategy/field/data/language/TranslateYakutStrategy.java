package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.YakutProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateYakut;

public class TranslateYakutStrategy extends TranslationStrategy<TranslateYakut> {
    public TranslateYakutStrategy() {
        super(YakutProvider.class);
    }

    @Override
    public Class<? extends TranslateYakut> getAnnotationClass() {
        return TranslateYakut.class;
    }
}
