package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TzotzilProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTzotzil;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTzotzilStrategy extends TranslationStrategy<TranslateTzotzil> {
    public TranslateTzotzilStrategy() {
        super(TzotzilProvider.class);
    }

    @Override
    public Class<TranslateTzotzil> getAnnotationClass() {
        return TranslateTzotzil.class;
    }
}
