package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KyrgyzProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKyrgyz;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateKyrgyzStrategy extends TranslationStrategy<TranslateKyrgyz> {
    public TranslateKyrgyzStrategy() {
        super(KyrgyzProvider.class);
    }

    @Override
    public Class<TranslateKyrgyz> getAnnotationClass() {
        return TranslateKyrgyz.class;
    }
}
