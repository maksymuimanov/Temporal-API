package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AsturianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAsturian;

public class TranslateAsturianStrategy extends TranslationStrategy<TranslateAsturian> {
    public TranslateAsturianStrategy() {
        super(AsturianProvider.class);
    }

    @Override
    public Class<? extends TranslateAsturian> getAnnotationClass() {
        return TranslateAsturian.class;
    }
}
