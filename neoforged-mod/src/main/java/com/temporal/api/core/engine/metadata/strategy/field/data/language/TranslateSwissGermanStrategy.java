package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SwissGermanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSwissGerman;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSwissGermanStrategy extends TranslationStrategy<TranslateSwissGerman> {
    public TranslateSwissGermanStrategy() {
        super(SwissGermanProvider.class);
    }

    @Override
    public Class<TranslateSwissGerman> getAnnotationClass() {
        return TranslateSwissGerman.class;
    }
}
