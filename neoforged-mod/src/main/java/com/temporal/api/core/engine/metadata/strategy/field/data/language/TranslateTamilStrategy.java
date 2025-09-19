package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TamilProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTamil;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTamilStrategy extends TranslationStrategy<TranslateTamil> {
    public TranslateTamilStrategy() {
        super(TamilProvider.class);
    }

    @Override
    public Class<TranslateTamil> getAnnotationClass() {
        return TranslateTamil.class;
    }
}
