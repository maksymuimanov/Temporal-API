package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BrazilianPortugueseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBrazilianPortuguese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBrazilianPortugueseStrategy extends TranslationStrategy<TranslateBrazilianPortuguese> {
    public TranslateBrazilianPortugueseStrategy() {
        super(BrazilianPortugueseProvider.class);
    }

    @Override
    public Class<TranslateBrazilianPortuguese> getAnnotationClass() {
        return TranslateBrazilianPortuguese.class;
    }
}
