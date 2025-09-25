package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ItalianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateItalian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateItalianStrategy extends TranslationStrategy<TranslateItalian> {
    public TranslateItalianStrategy() {
        super(ItalianProvider.class);
    }

    @Override
    public Class<TranslateItalian> getAnnotationClass() {
        return TranslateItalian.class;
    }
}
