package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MongolianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMongolian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMongolianStrategy extends TranslationStrategy<TranslateMongolian> {
    public TranslateMongolianStrategy() {
        super(MongolianProvider.class);
    }

    @Override
    public Class<? extends TranslateMongolian> getAnnotationClass() {
        return TranslateMongolian.class;
    }
}
