package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BritishEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBritishEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBritishEnglishStrategy extends TranslationStrategy<TranslateBritishEnglish> {
    public TranslateBritishEnglishStrategy() {
        super(BritishEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateBritishEnglish> getAnnotationClass() {
        return TranslateBritishEnglish.class;
    }
}
