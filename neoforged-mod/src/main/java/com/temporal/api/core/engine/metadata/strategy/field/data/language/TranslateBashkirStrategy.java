package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BashkirProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBashkir;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBashkirStrategy extends TranslationStrategy<TranslateBashkir> {
    public TranslateBashkirStrategy() {
        super(BashkirProvider.class);
    }

    @Override
    public Class<TranslateBashkir> getAnnotationClass() {
        return TranslateBashkir.class;
    }
}
