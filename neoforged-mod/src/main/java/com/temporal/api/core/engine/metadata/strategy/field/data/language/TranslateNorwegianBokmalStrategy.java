package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NorwegianBokmalProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNorwegianBokmal;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorwegianBokmalStrategy extends TranslationStrategy<TranslateNorwegianBokmal> {
    public TranslateNorwegianBokmalStrategy() {
        super(NorwegianBokmalProvider.class);
    }

    @Override
    public Class<TranslateNorwegianBokmal> getAnnotationClass() {
        return TranslateNorwegianBokmal.class;
    }
}
