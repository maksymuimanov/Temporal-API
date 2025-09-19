package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UruguayanSpanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUruguayanSpanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUruguayanSpanishStrategy extends TranslationStrategy<TranslateUruguayanSpanish> {
    public TranslateUruguayanSpanishStrategy() {
        super(UruguayanSpanishProvider.class);
    }

    @Override
    public Class<TranslateUruguayanSpanish> getAnnotationClass() {
        return TranslateUruguayanSpanish.class;
    }
}
