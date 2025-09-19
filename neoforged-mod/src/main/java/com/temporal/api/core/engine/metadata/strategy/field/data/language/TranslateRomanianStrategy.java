package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RomanianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRomanian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateRomanianStrategy extends TranslationStrategy<TranslateRomanian> {
    public TranslateRomanianStrategy() {
        super(RomanianProvider.class);
    }

    @Override
    public Class<TranslateRomanian> getAnnotationClass() {
        return TranslateRomanian.class;
    }
}
