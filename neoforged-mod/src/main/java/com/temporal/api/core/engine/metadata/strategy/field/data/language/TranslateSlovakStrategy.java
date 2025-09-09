package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SlovakProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSlovak;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSlovakStrategy extends TranslationStrategy<TranslateSlovak> {
    public TranslateSlovakStrategy() {
        super(SlovakProvider.class);
    }

    @Override
    public Class<? extends TranslateSlovak> getAnnotationClass() {
        return TranslateSlovak.class;
    }
}
