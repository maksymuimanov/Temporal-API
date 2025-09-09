package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CzechProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCzech;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCzechStrategy extends TranslationStrategy<TranslateCzech> {
    public TranslateCzechStrategy() {
        super(CzechProvider.class);
    }

    @Override
    public Class<? extends TranslateCzech> getAnnotationClass() {
        return TranslateCzech.class;
    }
}
