package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BavarianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBavarian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBavarianStrategy extends TranslationStrategy<TranslateBavarian> {
    public TranslateBavarianStrategy() {
        super(BavarianProvider.class);
    }

    @Override
    public Class<? extends TranslateBavarian> getAnnotationClass() {
        return TranslateBavarian.class;
    }
}
