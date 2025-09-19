package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NahuatlProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNahuatl;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNahuatlStrategy extends TranslationStrategy<TranslateNahuatl> {
    public TranslateNahuatlStrategy() {
        super(NahuatlProvider.class);
    }

    @Override
    public Class<TranslateNahuatl> getAnnotationClass() {
        return TranslateNahuatl.class;
    }
}
