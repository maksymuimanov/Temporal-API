package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IrishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIrish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIrishStrategy extends TranslationStrategy<TranslateIrish> {
    public TranslateIrishStrategy() {
        super(IrishProvider.class);
    }

    @Override
    public Class<TranslateIrish> getAnnotationClass() {
        return TranslateIrish.class;
    }
}
