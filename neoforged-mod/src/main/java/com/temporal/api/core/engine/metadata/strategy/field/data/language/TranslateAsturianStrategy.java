package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AsturianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAsturian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAsturianStrategy extends TranslationStrategy<TranslateAsturian> {
    public TranslateAsturianStrategy() {
        super(AsturianProvider.class);
    }

    @Override
    public Class<TranslateAsturian> getAnnotationClass() {
        return TranslateAsturian.class;
    }
}
