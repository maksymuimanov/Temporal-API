package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HawaiianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHawaiian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHawaiianStrategy extends TranslationStrategy<TranslateHawaiian> {
    public TranslateHawaiianStrategy() {
        super(HawaiianProvider.class);
    }

    @Override
    public Class<TranslateHawaiian> getAnnotationClass() {
        return TranslateHawaiian.class;
    }
}
