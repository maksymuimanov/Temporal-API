package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TatarProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTatar;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTatarStrategy extends TranslationStrategy<TranslateTatar> {
    public TranslateTatarStrategy() {
        super(TatarProvider.class);
    }

    @Override
    public Class<? extends TranslateTatar> getAnnotationClass() {
        return TranslateTatar.class;
    }
}
