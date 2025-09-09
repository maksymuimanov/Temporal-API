package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BosnianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBosnian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBosnianStrategy extends TranslationStrategy<TranslateBosnian> {
    public TranslateBosnianStrategy() {
        super(BosnianProvider.class);
    }

    @Override
    public Class<? extends TranslateBosnian> getAnnotationClass() {
        return TranslateBosnian.class;
    }
}
