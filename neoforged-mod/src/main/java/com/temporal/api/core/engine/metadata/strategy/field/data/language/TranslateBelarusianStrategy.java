package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BelarusianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBelarusian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBelarusianStrategy extends TranslationStrategy<TranslateBelarusian> {
    public TranslateBelarusianStrategy() {
        super(BelarusianProvider.class);
    }

    @Override
    public Class<? extends TranslateBelarusian> getAnnotationClass() {
        return TranslateBelarusian.class;
    }
}
