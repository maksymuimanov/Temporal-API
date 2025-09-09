package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ArabicProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateArabic;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateArabicStrategy extends TranslationStrategy<TranslateArabic> {
    public TranslateArabicStrategy() {
        super(ArabicProvider.class);
    }

    @Override
    public Class<? extends TranslateArabic> getAnnotationClass() {
        return TranslateArabic.class;
    }
}
