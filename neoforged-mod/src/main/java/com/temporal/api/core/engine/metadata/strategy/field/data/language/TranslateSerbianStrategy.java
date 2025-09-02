package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SerbianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSerbian;

public class TranslateSerbianStrategy extends TranslationStrategy<TranslateSerbian> {
    public TranslateSerbianStrategy() {
        super(SerbianProvider.class);
    }

    @Override
    public Class<? extends TranslateSerbian> getAnnotationClass() {
        return TranslateSerbian.class;
    }
}
