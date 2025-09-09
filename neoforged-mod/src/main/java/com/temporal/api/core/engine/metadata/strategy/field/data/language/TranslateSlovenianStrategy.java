package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SlovenianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSlovenian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSlovenianStrategy extends TranslationStrategy<TranslateSlovenian> {
    public TranslateSlovenianStrategy() {
        super(SlovenianProvider.class);
    }

    @Override
    public Class<? extends TranslateSlovenian> getAnnotationClass() {
        return TranslateSlovenian.class;
    }
}
