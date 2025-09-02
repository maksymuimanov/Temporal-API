package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MandarinProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMandarin;

public class TranslateMandarinStrategy extends TranslationStrategy<TranslateMandarin> {
    public TranslateMandarinStrategy() {
        super(MandarinProvider.class);
    }

    @Override
    public Class<? extends TranslateMandarin> getAnnotationClass() {
        return TranslateMandarin.class;
    }
}
