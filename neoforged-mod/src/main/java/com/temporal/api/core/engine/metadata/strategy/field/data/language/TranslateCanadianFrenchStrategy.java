package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CanadianFrenchProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCanadianFrench;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCanadianFrenchStrategy extends TranslationStrategy<TranslateCanadianFrench> {
    public TranslateCanadianFrenchStrategy() {
        super(CanadianFrenchProvider.class);
    }

    @Override
    public Class<? extends TranslateCanadianFrench> getAnnotationClass() {
        return TranslateCanadianFrench.class;
    }
}
