package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IdoProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIdo;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIdoStrategy extends TranslationStrategy<TranslateIdo> {
    public TranslateIdoStrategy() {
        super(IdoProvider.class);
    }

    @Override
    public Class<TranslateIdo> getAnnotationClass() {
        return TranslateIdo.class;
    }
}
