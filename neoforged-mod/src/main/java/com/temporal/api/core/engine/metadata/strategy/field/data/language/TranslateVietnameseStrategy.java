package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.VietnameseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateVietnamese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateVietnameseStrategy extends TranslationStrategy<TranslateVietnamese> {
    public TranslateVietnameseStrategy() {
        super(VietnameseProvider.class);
    }

    @Override
    public Class<TranslateVietnamese> getAnnotationClass() {
        return TranslateVietnamese.class;
    }
}
