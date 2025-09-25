package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GreekProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGreek;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGreekStrategy extends TranslationStrategy<TranslateGreek> {
    public TranslateGreekStrategy() {
        super(GreekProvider.class);
    }

    @Override
    public Class<TranslateGreek> getAnnotationClass() {
        return TranslateGreek.class;
    }
}
