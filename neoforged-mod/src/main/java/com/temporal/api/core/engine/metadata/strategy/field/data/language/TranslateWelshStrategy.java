package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.WelshProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateWelsh;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateWelshStrategy extends TranslationStrategy<TranslateWelsh> {
    public TranslateWelshStrategy() {
        super(WelshProvider.class);
    }

    @Override
    public Class<TranslateWelsh> getAnnotationClass() {
        return TranslateWelsh.class;
    }
}
