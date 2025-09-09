package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RussianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRussian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateRussianStrategy extends TranslationStrategy<TranslateRussian> {
    public TranslateRussianStrategy() {
        super(RussianProvider.class);
    }

    @Override
    public Class<? extends TranslateRussian> getAnnotationClass() {
        return TranslateRussian.class;
    }
}
