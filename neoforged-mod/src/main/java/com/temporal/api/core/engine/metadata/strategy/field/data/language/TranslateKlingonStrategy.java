package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KlingonProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKlingon;

public class TranslateKlingonStrategy extends TranslationStrategy<TranslateKlingon> {
    public TranslateKlingonStrategy() {
        super(KlingonProvider.class);
    }

    @Override
    public Class<? extends TranslateKlingon> getAnnotationClass() {
        return TranslateKlingon.class;
    }
}
