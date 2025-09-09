package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FriulianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFriulian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFriulianStrategy extends TranslationStrategy<TranslateFriulian> {
    public TranslateFriulianStrategy() {
        super(FriulianProvider.class);
    }

    @Override
    public Class<? extends TranslateFriulian> getAnnotationClass() {
        return TranslateFriulian.class;
    }
}
