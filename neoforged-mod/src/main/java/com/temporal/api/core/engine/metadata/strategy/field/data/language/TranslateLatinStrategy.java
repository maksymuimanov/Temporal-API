package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatinProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatin;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatinStrategy extends TranslationStrategy<TranslateLatin> {
    public TranslateLatinStrategy() {
        super(LatinProvider.class);
    }

    @Override
    public Class<TranslateLatin> getAnnotationClass() {
        return TranslateLatin.class;
    }
}
