package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UkrainianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUkrainian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUkrainianStrategy extends TranslationStrategy<TranslateUkrainian> {
    public TranslateUkrainianStrategy() {
        super(UkrainianProvider.class);
    }

    @Override
    public Class<TranslateUkrainian> getAnnotationClass() {
        return TranslateUkrainian.class;
    }
}
