package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.QuenyaProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateQuenya;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateQuenyaStrategy extends TranslationStrategy<TranslateQuenya> {
    public TranslateQuenyaStrategy() {
        super(QuenyaProvider.class);
    }

    @Override
    public Class<? extends TranslateQuenya> getAnnotationClass() {
        return TranslateQuenya.class;
    }
}
