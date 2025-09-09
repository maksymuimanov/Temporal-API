package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HighNorwegianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHighNorwegian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHighNorwegianStrategy extends TranslationStrategy<TranslateHighNorwegian> {
    public TranslateHighNorwegianStrategy() {
        super(HighNorwegianProvider.class);
    }

    @Override
    public Class<? extends TranslateHighNorwegian> getAnnotationClass() {
        return TranslateHighNorwegian.class;
    }
}
