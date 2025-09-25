package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MalayProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMalay;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMalayStrategy extends TranslationStrategy<TranslateMalay> {
    public TranslateMalayStrategy() {
        super(MalayProvider.class);
    }

    @Override
    public Class<TranslateMalay> getAnnotationClass() {
        return TranslateMalay.class;
    }
}
