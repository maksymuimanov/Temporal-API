package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.YiddishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateYiddish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateYiddishStrategy extends TranslationStrategy<TranslateYiddish> {
    public TranslateYiddishStrategy() {
        super(YiddishProvider.class);
    }

    @Override
    public Class<TranslateYiddish> getAnnotationClass() {
        return TranslateYiddish.class;
    }
}
