package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UpsideDownBritishEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUpsideDownBritishEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUpsideDownBritishEnglishStrategy extends TranslationStrategy<TranslateUpsideDownBritishEnglish> {
    public TranslateUpsideDownBritishEnglishStrategy() {
        super(UpsideDownBritishEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateUpsideDownBritishEnglish> getAnnotationClass() {
        return TranslateUpsideDownBritishEnglish.class;
    }
}
