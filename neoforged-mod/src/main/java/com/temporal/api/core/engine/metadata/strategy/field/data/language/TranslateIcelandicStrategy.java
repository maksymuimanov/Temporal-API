package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IcelandicProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIcelandic;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIcelandicStrategy extends TranslationStrategy<TranslateIcelandic> {
    public TranslateIcelandicStrategy() {
        super(IcelandicProvider.class);
    }

    @Override
    public Class<TranslateIcelandic> getAnnotationClass() {
        return TranslateIcelandic.class;
    }
}
