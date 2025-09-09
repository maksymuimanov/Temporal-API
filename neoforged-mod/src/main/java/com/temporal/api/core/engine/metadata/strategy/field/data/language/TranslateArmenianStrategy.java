package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ArmenianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateArmenian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateArmenianStrategy extends TranslationStrategy<TranslateArmenian> {
    public TranslateArmenianStrategy() {
        super(ArmenianProvider.class);
    }

    @Override
    public Class<? extends TranslateArmenian> getAnnotationClass() {
        return TranslateArmenian.class;
    }
}
