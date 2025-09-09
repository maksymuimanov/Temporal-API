package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SomaliProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSomali;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSomaliStrategy extends TranslationStrategy<TranslateSomali> {
    public TranslateSomaliStrategy() {
        super(SomaliProvider.class);
    }

    @Override
    public Class<? extends TranslateSomali> getAnnotationClass() {
        return TranslateSomali.class;
    }
}
