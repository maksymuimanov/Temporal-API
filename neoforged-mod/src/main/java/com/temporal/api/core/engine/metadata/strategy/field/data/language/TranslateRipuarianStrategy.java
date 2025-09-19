package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RipuarianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRipuarian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateRipuarianStrategy extends TranslationStrategy<TranslateRipuarian> {
    public TranslateRipuarianStrategy() {
        super(RipuarianProvider.class);
    }

    @Override
    public Class<TranslateRipuarian> getAnnotationClass() {
        return TranslateRipuarian.class;
    }
}
