package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KannadaProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKannada;

public class TranslateKannadaStrategy extends TranslationStrategy<TranslateKannada> {
    public TranslateKannadaStrategy() {
        super(KannadaProvider.class);
    }

    @Override
    public Class<? extends TranslateKannada> getAnnotationClass() {
        return TranslateKannada.class;
    }
}
