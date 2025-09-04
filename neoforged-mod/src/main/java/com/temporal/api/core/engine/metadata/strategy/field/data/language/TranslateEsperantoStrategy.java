package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EsperantoProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEsperanto;

public class TranslateEsperantoStrategy extends TranslationStrategy<TranslateEsperanto> {
    public TranslateEsperantoStrategy() {
        super(EsperantoProvider.class);
    }

    @Override
    public Class<? extends TranslateEsperanto> getAnnotationClass() {
        return TranslateEsperanto.class;
    }
}
