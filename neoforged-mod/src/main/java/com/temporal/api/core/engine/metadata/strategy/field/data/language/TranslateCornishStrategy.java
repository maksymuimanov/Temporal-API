package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CornishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCornish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCornishStrategy extends TranslationStrategy<TranslateCornish> {
    public TranslateCornishStrategy() {
        super(CornishProvider.class);
    }

    @Override
    public Class<TranslateCornish> getAnnotationClass() {
        return TranslateCornish.class;
    }
}
