package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GeorgianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGeorgian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGeorgianStrategy extends TranslationStrategy<TranslateGeorgian> {
    public TranslateGeorgianStrategy() {
        super(GeorgianProvider.class);
    }

    @Override
    public Class<? extends TranslateGeorgian> getAnnotationClass() {
        return TranslateGeorgian.class;
    }
}
