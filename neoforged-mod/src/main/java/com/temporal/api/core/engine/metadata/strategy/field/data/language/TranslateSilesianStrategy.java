package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SilesianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSilesian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSilesianStrategy extends TranslationStrategy<TranslateSilesian> {
    public TranslateSilesianStrategy() {
        super(SilesianProvider.class);
    }

    @Override
    public Class<? extends TranslateSilesian> getAnnotationClass() {
        return TranslateSilesian.class;
    }
}
