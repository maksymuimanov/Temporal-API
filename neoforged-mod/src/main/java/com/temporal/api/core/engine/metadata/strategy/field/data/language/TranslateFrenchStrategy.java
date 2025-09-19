package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FrenchProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFrench;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFrenchStrategy extends TranslationStrategy<TranslateFrench> {
    public TranslateFrenchStrategy() {
        super(FrenchProvider.class);
    }

    @Override
    public Class<TranslateFrench> getAnnotationClass() {
        return TranslateFrench.class;
    }
}
