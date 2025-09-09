package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HebrewProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHebrew;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHebrewStrategy extends TranslationStrategy<TranslateHebrew> {
    public TranslateHebrewStrategy() {
        super(HebrewProvider.class);
    }

    @Override
    public Class<? extends TranslateHebrew> getAnnotationClass() {
        return TranslateHebrew.class;
    }
}
