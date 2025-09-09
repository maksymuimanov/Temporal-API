package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TurkishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTurkish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTurkishStrategy extends TranslationStrategy<TranslateTurkish> {
    public TranslateTurkishStrategy() {
        super(TurkishProvider.class);
    }

    @Override
    public Class<? extends TranslateTurkish> getAnnotationClass() {
        return TranslateTurkish.class;
    }
}
