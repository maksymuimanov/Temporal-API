package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HalychianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHalychian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHalychianStrategy extends TranslationStrategy<TranslateHalychian> {
    public TranslateHalychianStrategy() {
        super(HalychianProvider.class);
    }

    @Override
    public Class<? extends TranslateHalychian> getAnnotationClass() {
        return TranslateHalychian.class;
    }
}
