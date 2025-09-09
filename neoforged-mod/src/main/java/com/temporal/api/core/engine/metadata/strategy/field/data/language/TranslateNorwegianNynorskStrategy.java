package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NorwegianNynorskProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNorwegianNynorsk;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorwegianNynorskStrategy extends TranslationStrategy<TranslateNorwegianNynorsk> {
    public TranslateNorwegianNynorskStrategy() {
        super(NorwegianNynorskProvider.class);
    }

    @Override
    public Class<? extends TranslateNorwegianNynorsk> getAnnotationClass() {
        return TranslateNorwegianNynorsk.class;
    }
}
