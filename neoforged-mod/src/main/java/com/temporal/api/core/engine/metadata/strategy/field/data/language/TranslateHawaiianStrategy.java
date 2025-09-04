package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HawaiianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHawaiian;

public class TranslateHawaiianStrategy extends TranslationStrategy<TranslateHawaiian> {
    public TranslateHawaiianStrategy() {
        super(HawaiianProvider.class);
    }

    @Override
    public Class<? extends TranslateHawaiian> getAnnotationClass() {
        return TranslateHawaiian.class;
    }
}
