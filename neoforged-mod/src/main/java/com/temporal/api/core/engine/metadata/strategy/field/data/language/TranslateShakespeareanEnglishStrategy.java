package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ShakespeareanEnglishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateShakespeareanEnglish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateShakespeareanEnglishStrategy extends TranslationStrategy<TranslateShakespeareanEnglish> {
    public TranslateShakespeareanEnglishStrategy() {
        super(ShakespeareanEnglishProvider.class);
    }

    @Override
    public Class<TranslateShakespeareanEnglish> getAnnotationClass() {
        return TranslateShakespeareanEnglish.class;
    }
}
