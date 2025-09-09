package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KoreanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKorean;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateKoreanStrategy extends TranslationStrategy<TranslateKorean> {
    public TranslateKoreanStrategy() {
        super(KoreanProvider.class);
    }

    @Override
    public Class<? extends TranslateKorean> getAnnotationClass() {
        return TranslateKorean.class;
    }
}
