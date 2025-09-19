package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.EastFranconianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEastFranconian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateEastFranconianStrategy extends TranslationStrategy<TranslateEastFranconian> {
    public TranslateEastFranconianStrategy() {
        super(EastFranconianProvider.class);
    }

    @Override
    public Class<TranslateEastFranconian> getAnnotationClass() {
        return TranslateEastFranconian.class;
    }
}
