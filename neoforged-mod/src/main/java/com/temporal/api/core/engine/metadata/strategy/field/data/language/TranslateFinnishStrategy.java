package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FinnishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFinnish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFinnishStrategy extends TranslationStrategy<TranslateFinnish> {
    public TranslateFinnishStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public Class<TranslateFinnish> getAnnotationClass() {
        return TranslateFinnish.class;
    }
}
