package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatinProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatin;

public class TranslateLatinStrategy extends TranslationStrategy<TranslateLatin> {
    public TranslateLatinStrategy() {
        super(LatinProvider.class);
    }

    @Override
    public Class<? extends TranslateLatin> getAnnotationClass() {
        return TranslateLatin.class;
    }
}
