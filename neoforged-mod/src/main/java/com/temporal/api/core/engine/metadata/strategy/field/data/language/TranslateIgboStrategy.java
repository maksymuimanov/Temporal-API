package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IgboProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIgbo;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIgboStrategy extends TranslationStrategy<TranslateIgbo> {
    public TranslateIgboStrategy() {
        super(IgboProvider.class);
    }

    @Override
    public Class<? extends TranslateIgbo> getAnnotationClass() {
        return TranslateIgbo.class;
    }
}
