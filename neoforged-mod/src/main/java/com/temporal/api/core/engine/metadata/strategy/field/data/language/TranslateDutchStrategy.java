package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.DutchProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateDutch;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateDutchStrategy extends TranslationStrategy<TranslateDutch> {
    public TranslateDutchStrategy() {
        super(DutchProvider.class);
    }

    @Override
    public Class<TranslateDutch> getAnnotationClass() {
        return TranslateDutch.class;
    }
}
