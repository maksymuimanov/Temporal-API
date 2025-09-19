package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ValencianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateValencian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateValencianStrategy extends TranslationStrategy<TranslateValencian> {
    public TranslateValencianStrategy() {
        super(ValencianProvider.class);
    }

    @Override
    public Class<TranslateValencian> getAnnotationClass() {
        return TranslateValencian.class;
    }
}
