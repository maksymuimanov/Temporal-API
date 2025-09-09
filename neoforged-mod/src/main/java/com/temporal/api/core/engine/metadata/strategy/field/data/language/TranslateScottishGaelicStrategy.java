package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ScottishGaelicProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateScottishGaelic;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateScottishGaelicStrategy extends TranslationStrategy<TranslateScottishGaelic> {
    public TranslateScottishGaelicStrategy() {
        super(ScottishGaelicProvider.class);
    }

    @Override
    public Class<? extends TranslateScottishGaelic> getAnnotationClass() {
        return TranslateScottishGaelic.class;
    }
}
