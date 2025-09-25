package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LimburgishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLimburgish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLimburgishStrategy extends TranslationStrategy<TranslateLimburgish> {
    public TranslateLimburgishStrategy() {
        super(LimburgishProvider.class);
    }

    @Override
    public Class<TranslateLimburgish> getAnnotationClass() {
        return TranslateLimburgish.class;
    }
}
