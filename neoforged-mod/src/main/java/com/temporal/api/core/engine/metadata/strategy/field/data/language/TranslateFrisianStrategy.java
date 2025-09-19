package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FrisianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFrisian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFrisianStrategy extends TranslationStrategy<TranslateFrisian> {
    public TranslateFrisianStrategy() {
        super(FrisianProvider.class);
    }

    @Override
    public Class<TranslateFrisian> getAnnotationClass() {
        return TranslateFrisian.class;
    }
}
