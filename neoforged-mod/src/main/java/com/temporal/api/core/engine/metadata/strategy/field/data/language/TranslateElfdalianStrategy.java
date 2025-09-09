package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ElfdalianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateElfdalian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateElfdalianStrategy extends TranslationStrategy<TranslateElfdalian> {
    public TranslateElfdalianStrategy() {
        super(ElfdalianProvider.class);
    }

    @Override
    public Class<? extends TranslateElfdalian> getAnnotationClass() {
        return TranslateElfdalian.class;
    }
}
