package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RusynProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRusyn;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateRusynStrategy extends TranslationStrategy<TranslateRusyn> {
    public TranslateRusynStrategy() {
        super(RusynProvider.class);
    }

    @Override
    public Class<? extends TranslateRusyn> getAnnotationClass() {
        return TranslateRusyn.class;
    }
}
