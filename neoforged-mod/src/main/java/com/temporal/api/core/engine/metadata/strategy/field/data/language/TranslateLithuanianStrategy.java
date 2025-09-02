package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LithuanianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLithuanian;

public class TranslateLithuanianStrategy extends TranslationStrategy<TranslateLithuanian> {
    public TranslateLithuanianStrategy() {
        super(LithuanianProvider.class);
    }

    @Override
    public Class<? extends TranslateLithuanian> getAnnotationClass() {
        return TranslateLithuanian.class;
    }
}
