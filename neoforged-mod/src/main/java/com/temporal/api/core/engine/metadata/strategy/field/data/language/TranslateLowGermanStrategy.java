package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LowGermanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLowGerman;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLowGermanStrategy extends TranslationStrategy<TranslateLowGerman> {
    public TranslateLowGermanStrategy() {
        super(LowGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateLowGerman> getAnnotationClass() {
        return TranslateLowGerman.class;
    }
}
