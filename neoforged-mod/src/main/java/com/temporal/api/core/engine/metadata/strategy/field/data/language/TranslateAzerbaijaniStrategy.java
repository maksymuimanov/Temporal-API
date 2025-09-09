package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AzerbaijaniProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAzerbaijani;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAzerbaijaniStrategy extends TranslationStrategy<TranslateAzerbaijani> {
    public TranslateAzerbaijaniStrategy() {
        super(AzerbaijaniProvider.class);
    }

    @Override
    public Class<? extends TranslateAzerbaijani> getAnnotationClass() {
        return TranslateAzerbaijani.class;
    }
}
