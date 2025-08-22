package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSerbian;
import com.temporal.api.core.event.data.language.provider.SerbianProvider;

public class TranslateSerbianStrategy extends TranslationStrategy<TranslateSerbian> {
    public TranslateSerbianStrategy() {
        super(SerbianProvider.class);
    }

    @Override
    public Class<? extends TranslateSerbian> getAnnotationClass() {
        return TranslateSerbian.class;
    }
}
