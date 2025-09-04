package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AndalusianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAndalusian;

public class TranslateAndalusianStrategy extends TranslationStrategy<TranslateAndalusian> {
    public TranslateAndalusianStrategy() {
        super(AndalusianProvider.class);
    }

    @Override
    public Class<? extends TranslateAndalusian> getAnnotationClass() {
        return TranslateAndalusian.class;
    }
}
