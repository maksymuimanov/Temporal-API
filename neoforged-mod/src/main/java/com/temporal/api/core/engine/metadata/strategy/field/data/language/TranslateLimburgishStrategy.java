package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LimburgishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLimburgish;

public class TranslateLimburgishStrategy extends TranslationStrategy<TranslateLimburgish> {
    public TranslateLimburgishStrategy() {
        super(LimburgishProvider.class);
    }

    @Override
    public Class<? extends TranslateLimburgish> getAnnotationClass() {
        return TranslateLimburgish.class;
    }
}
