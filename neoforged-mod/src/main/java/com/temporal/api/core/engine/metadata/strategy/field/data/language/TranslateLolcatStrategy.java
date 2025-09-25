package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LolcatProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLolcat;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLolcatStrategy extends TranslationStrategy<TranslateLolcat> {
    public TranslateLolcatStrategy() {
        super(LolcatProvider.class);
    }

    @Override
    public Class<TranslateLolcat> getAnnotationClass() {
        return TranslateLolcat.class;
    }
}
