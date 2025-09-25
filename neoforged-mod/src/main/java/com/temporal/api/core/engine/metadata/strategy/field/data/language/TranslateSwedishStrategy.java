package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SwedishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSwedish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSwedishStrategy extends TranslationStrategy<TranslateSwedish> {
    public TranslateSwedishStrategy() {
        super(SwedishProvider.class);
    }

    @Override
    public Class<TranslateSwedish> getAnnotationClass() {
        return TranslateSwedish.class;
    }
}
