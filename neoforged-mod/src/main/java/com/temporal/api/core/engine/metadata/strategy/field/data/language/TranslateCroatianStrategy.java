package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CroatianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCroatian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCroatianStrategy extends TranslationStrategy<TranslateCroatian> {
    public TranslateCroatianStrategy() {
        super(CroatianProvider.class);
    }

    @Override
    public Class<? extends TranslateCroatian> getAnnotationClass() {
        return TranslateCroatian.class;
    }
}
