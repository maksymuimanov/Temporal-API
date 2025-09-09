package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KannadaProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKannada;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateKannadaStrategy extends TranslationStrategy<TranslateKannada> {
    public TranslateKannadaStrategy() {
        super(KannadaProvider.class);
    }

    @Override
    public Class<? extends TranslateKannada> getAnnotationClass() {
        return TranslateKannada.class;
    }
}
