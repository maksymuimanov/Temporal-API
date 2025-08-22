package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateThai;
import com.temporal.api.core.event.data.language.provider.ThaiProvider;

public class TranslateThaiStrategy extends TranslationStrategy<TranslateThai> {
    public TranslateThaiStrategy() {
        super(ThaiProvider.class);
    }

    @Override
    public Class<? extends TranslateThai> getAnnotationClass() {
        return TranslateThai.class;
    }
}
