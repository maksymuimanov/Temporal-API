package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PersianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePersian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePersianStrategy extends TranslationStrategy<TranslatePersian> {
    public TranslatePersianStrategy() {
        super(PersianProvider.class);
    }

    @Override
    public Class<? extends TranslatePersian> getAnnotationClass() {
        return TranslatePersian.class;
    }
}
