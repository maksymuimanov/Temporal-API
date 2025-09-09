package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EstonianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEstonian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateEstonianStrategy extends TranslationStrategy<TranslateEstonian> {
    public TranslateEstonianStrategy() {
        super(EstonianProvider.class);
    }

    @Override
    public Class<? extends TranslateEstonian> getAnnotationClass() {
        return TranslateEstonian.class;
    }
}
