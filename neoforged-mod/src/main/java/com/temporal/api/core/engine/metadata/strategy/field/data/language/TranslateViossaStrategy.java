package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ViossaProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateViossa;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateViossaStrategy extends TranslationStrategy<TranslateViossa> {
    public TranslateViossaStrategy() {
        super(ViossaProvider.class);
    }

    @Override
    public Class<? extends TranslateViossa> getAnnotationClass() {
        return TranslateViossa.class;
    }
}
