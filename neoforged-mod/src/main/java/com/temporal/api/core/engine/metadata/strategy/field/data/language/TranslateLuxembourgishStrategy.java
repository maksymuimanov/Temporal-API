package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LuxembourgishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLuxembourgish;

public class TranslateLuxembourgishStrategy extends TranslationStrategy<TranslateLuxembourgish> {
    public TranslateLuxembourgishStrategy() {
        super(LuxembourgishProvider.class);
    }

    @Override
    public Class<? extends TranslateLuxembourgish> getAnnotationClass() {
        return TranslateLuxembourgish.class;
    }
}
