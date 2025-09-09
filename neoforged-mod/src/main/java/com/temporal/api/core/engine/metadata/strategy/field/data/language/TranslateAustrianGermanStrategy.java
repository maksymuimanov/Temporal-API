package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AustrianGermanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAustrianGerman;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAustrianGermanStrategy extends TranslationStrategy<TranslateAustrianGerman> {
    public TranslateAustrianGermanStrategy() {
        super(AustrianGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateAustrianGerman> getAnnotationClass() {
        return TranslateAustrianGerman.class;
    }
}
