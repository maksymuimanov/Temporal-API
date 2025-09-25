package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FlemishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFlemish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFlemishStrategy extends TranslationStrategy<TranslateFlemish> {
    public TranslateFlemishStrategy() {
        super(FlemishProvider.class);
    }

    @Override
    public Class<TranslateFlemish> getAnnotationClass() {
        return TranslateFlemish.class;
    }
}
