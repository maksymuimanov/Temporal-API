package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ThaiProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateThai;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateThaiStrategy extends TranslationStrategy<TranslateThai> {
    public TranslateThaiStrategy() {
        super(ThaiProvider.class);
    }

    @Override
    public Class<TranslateThai> getAnnotationClass() {
        return TranslateThai.class;
    }
}
