package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BrabantianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBrabantian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBrabantianStrategy extends TranslationStrategy<TranslateBrabantian> {
    public TranslateBrabantianStrategy() {
        super(BrabantianProvider.class);
    }

    @Override
    public Class<TranslateBrabantian> getAnnotationClass() {
        return TranslateBrabantian.class;
    }
}
