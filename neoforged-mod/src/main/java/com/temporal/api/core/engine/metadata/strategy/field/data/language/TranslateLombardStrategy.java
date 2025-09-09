package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LombardProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLombard;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLombardStrategy extends TranslationStrategy<TranslateLombard> {
    public TranslateLombardStrategy() {
        super(LombardProvider.class);
    }

    @Override
    public Class<? extends TranslateLombard> getAnnotationClass() {
        return TranslateLombard.class;
    }
}
