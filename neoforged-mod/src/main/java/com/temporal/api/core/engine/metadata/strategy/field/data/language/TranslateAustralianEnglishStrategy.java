package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AustralianEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAustralianEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAustralianEnglishStrategy extends TranslationStrategy<TranslateAustralianEnglish> {
    public TranslateAustralianEnglishStrategy() {
        super(AustralianEnglishProvider.class);
    }

    @Override
    public Class<TranslateAustralianEnglish> getAnnotationClass() {
        return TranslateAustralianEnglish.class;
    }
}
