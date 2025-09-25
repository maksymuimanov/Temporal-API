package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SpanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSpanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSpanishStrategy extends TranslationStrategy<TranslateSpanish> {
    public TranslateSpanishStrategy() {
        super(SpanishProvider.class);
    }

    @Override
    public Class<TranslateSpanish> getAnnotationClass() {
        return TranslateSpanish.class;
    }
}
