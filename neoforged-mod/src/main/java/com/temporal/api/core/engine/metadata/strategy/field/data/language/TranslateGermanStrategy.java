package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GermanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGerman;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGermanStrategy extends TranslationStrategy<TranslateGerman> {
    public TranslateGermanStrategy() {
        super(GermanProvider.class);
    }

    @Override
    public Class<? extends TranslateGerman> getAnnotationClass() {
        return TranslateGerman.class;
    }
}
