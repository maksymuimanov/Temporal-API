package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CatalanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCatalan;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCatalanStrategy extends TranslationStrategy<TranslateCatalan> {
    public TranslateCatalanStrategy() {
        super(CatalanProvider.class);
    }

    @Override
    public Class<TranslateCatalan> getAnnotationClass() {
        return TranslateCatalan.class;
    }
}
