package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ChileanSpanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateChileanSpanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateChileanSpanishStrategy extends TranslationStrategy<TranslateChileanSpanish> {
    public TranslateChileanSpanishStrategy() {
        super(ChileanSpanishProvider.class);
    }

    @Override
    public Class<TranslateChileanSpanish> getAnnotationClass() {
        return TranslateChileanSpanish.class;
    }
}
