package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PortugueseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePortuguese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePortugueseStrategy extends TranslationStrategy<TranslatePortuguese> {
    public TranslatePortugueseStrategy() {
        super(PortugueseProvider.class);
    }

    @Override
    public Class<TranslatePortuguese> getAnnotationClass() {
        return TranslatePortuguese.class;
    }
}
