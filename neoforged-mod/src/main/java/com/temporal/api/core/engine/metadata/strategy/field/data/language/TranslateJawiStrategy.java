package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.JawiProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateJawi;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateJawiStrategy extends TranslationStrategy<TranslateJawi> {
    public TranslateJawiStrategy() {
        super(JawiProvider.class);
    }

    @Override
    public Class<? extends TranslateJawi> getAnnotationClass() {
        return TranslateJawi.class;
    }
}
