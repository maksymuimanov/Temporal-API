package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateLithuanian;
import com.temporal.api.core.event.data.language.provider.LithuanianProvider;

public class TranslateLithuanianStrategy extends TranslationStrategy<TranslateLithuanian> {
    public TranslateLithuanianStrategy() {
        super(LithuanianProvider.class);
    }

    @Override
    public Class<? extends TranslateLithuanian> getAnnotationClass() {
        return TranslateLithuanian.class;
    }
}
