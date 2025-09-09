package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IndonesianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIndonesian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIndonesianStrategy extends TranslationStrategy<TranslateIndonesian> {
    public TranslateIndonesianStrategy() {
        super(IndonesianProvider.class);
    }

    @Override
    public Class<? extends TranslateIndonesian> getAnnotationClass() {
        return TranslateIndonesian.class;
    }
}
