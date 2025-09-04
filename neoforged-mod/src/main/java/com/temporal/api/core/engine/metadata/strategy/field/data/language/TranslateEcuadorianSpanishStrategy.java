package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EcuadorianSpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEcuadorianSpanish;

public class TranslateEcuadorianSpanishStrategy extends TranslationStrategy<TranslateEcuadorianSpanish> {
    public TranslateEcuadorianSpanishStrategy() {
        super(EcuadorianSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateEcuadorianSpanish> getAnnotationClass() {
        return TranslateEcuadorianSpanish.class;
    }
}
