package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LithuanianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLithuanian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLithuanianStrategy extends TranslationStrategy<TranslateLithuanian> {
    public TranslateLithuanianStrategy() {
        super(LithuanianProvider.class);
    }

    @Override
    public Class<TranslateLithuanian> getAnnotationClass() {
        return TranslateLithuanian.class;
    }
}
