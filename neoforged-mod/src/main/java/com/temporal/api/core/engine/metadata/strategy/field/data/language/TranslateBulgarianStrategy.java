package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BulgarianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBulgarian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBulgarianStrategy extends TranslationStrategy<TranslateBulgarian> {
    public TranslateBulgarianStrategy() {
        super(BulgarianProvider.class);
    }

    @Override
    public Class<? extends TranslateBulgarian> getAnnotationClass() {
        return TranslateBulgarian.class;
    }
}
