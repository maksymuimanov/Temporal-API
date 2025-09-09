package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.DanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateDanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateDanishStrategy extends TranslationStrategy<TranslateDanish> {
    public TranslateDanishStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public Class<? extends TranslateDanish> getAnnotationClass() {
        return TranslateDanish.class;
    }
}
