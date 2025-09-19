package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AmericanEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAmericanEnglishStrategy extends TranslationStrategy<TranslateAmericanEnglish> {
    public TranslateAmericanEnglishStrategy() {
        super(AmericanEnglishProvider.class);
    }

    @Override
    public Class<TranslateAmericanEnglish> getAnnotationClass() {
        return TranslateAmericanEnglish.class;
    }
}
