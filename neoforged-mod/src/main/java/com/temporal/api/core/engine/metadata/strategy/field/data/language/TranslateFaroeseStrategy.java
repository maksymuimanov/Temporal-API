package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FaroeseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFaroese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFaroeseStrategy extends TranslationStrategy<TranslateFaroese> {
    public TranslateFaroeseStrategy() {
        super(FaroeseProvider.class);
    }

    @Override
    public Class<? extends TranslateFaroese> getAnnotationClass() {
        return TranslateFaroese.class;
    }
}
