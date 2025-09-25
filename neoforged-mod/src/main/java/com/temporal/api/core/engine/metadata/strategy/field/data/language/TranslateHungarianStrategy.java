package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HungarianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHungarian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHungarianStrategy extends TranslationStrategy<TranslateHungarian> {
    public TranslateHungarianStrategy() {
        super(HungarianProvider.class);
    }

    @Override
    public Class<TranslateHungarian> getAnnotationClass() {
        return TranslateHungarian.class;
    }
}
