package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateMandarin;
import com.temporal.api.core.event.data.language.provider.MandarinProvider;

public class TranslateMandarinStrategy extends TranslationStrategy<TranslateMandarin> {
    public TranslateMandarinStrategy() {
        super(MandarinProvider.class);
    }

    @Override
    public Class<? extends TranslateMandarin> getAnnotationClass() {
        return TranslateMandarin.class;
    }
}
