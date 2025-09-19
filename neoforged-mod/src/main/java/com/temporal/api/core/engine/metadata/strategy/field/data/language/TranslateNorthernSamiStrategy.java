package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NorthernSamiProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNorthernSami;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorthernSamiStrategy extends TranslationStrategy<TranslateNorthernSami> {
    public TranslateNorthernSamiStrategy() {
        super(NorthernSamiProvider.class);
    }

    @Override
    public Class<TranslateNorthernSami> getAnnotationClass() {
        return TranslateNorthernSami.class;
    }
}
