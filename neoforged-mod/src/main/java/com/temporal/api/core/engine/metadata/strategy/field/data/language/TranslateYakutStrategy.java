package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.YakutProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateYakut;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateYakutStrategy extends TranslationStrategy<TranslateYakut> {
    public TranslateYakutStrategy() {
        super(YakutProvider.class);
    }

    @Override
    public Class<TranslateYakut> getAnnotationClass() {
        return TranslateYakut.class;
    }
}
