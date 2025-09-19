package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LojbanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLojban;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLojbanStrategy extends TranslationStrategy<TranslateLojban> {
    public TranslateLojbanStrategy() {
        super(LojbanProvider.class);
    }

    @Override
    public Class<TranslateLojban> getAnnotationClass() {
        return TranslateLojban.class;
    }
}
