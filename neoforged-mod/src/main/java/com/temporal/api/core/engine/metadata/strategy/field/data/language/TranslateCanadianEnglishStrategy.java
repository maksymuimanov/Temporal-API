package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CanadianEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCanadianEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCanadianEnglishStrategy extends TranslationStrategy<TranslateCanadianEnglish> {
    public TranslateCanadianEnglishStrategy() {
        super(CanadianEnglishProvider.class);
    }

    @Override
    public Class<TranslateCanadianEnglish> getAnnotationClass() {
        return TranslateCanadianEnglish.class;
    }
}
