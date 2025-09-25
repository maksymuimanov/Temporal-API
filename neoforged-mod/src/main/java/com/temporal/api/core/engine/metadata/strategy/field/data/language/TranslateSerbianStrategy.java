package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SerbianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSerbian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSerbianStrategy extends TranslationStrategy<TranslateSerbian> {
    public TranslateSerbianStrategy() {
        super(SerbianProvider.class);
    }

    @Override
    public Class<TranslateSerbian> getAnnotationClass() {
        return TranslateSerbian.class;
    }
}
