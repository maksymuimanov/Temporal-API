package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BasqueProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBasque;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBasqueStrategy extends TranslationStrategy<TranslateBasque> {
    public TranslateBasqueStrategy() {
        super(BasqueProvider.class);
    }

    @Override
    public Class<? extends TranslateBasque> getAnnotationClass() {
        return TranslateBasque.class;
    }
}
