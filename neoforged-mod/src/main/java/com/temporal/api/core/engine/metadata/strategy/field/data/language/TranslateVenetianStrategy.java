package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.VenetianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateVenetian;

public class TranslateVenetianStrategy extends TranslationStrategy<TranslateVenetian> {
    public TranslateVenetianStrategy() {
        super(VenetianProvider.class);
    }

    @Override
    public Class<? extends TranslateVenetian> getAnnotationClass() {
        return TranslateVenetian.class;
    }
}
