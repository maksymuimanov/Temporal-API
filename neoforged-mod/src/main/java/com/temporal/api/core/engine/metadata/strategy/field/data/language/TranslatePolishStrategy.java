package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PolishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePolish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePolishStrategy extends TranslationStrategy<TranslatePolish> {
    public TranslatePolishStrategy() {
        super(PolishProvider.class);
    }

    @Override
    public Class<? extends TranslatePolish> getAnnotationClass() {
        return TranslatePolish.class;
    }
}
