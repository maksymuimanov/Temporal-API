package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatinBelarusianProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatinBelarusian;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatinBelarusianStrategy extends TranslationStrategy<TranslateLatinBelarusian> {
    public TranslateLatinBelarusianStrategy() {
        super(LatinBelarusianProvider.class);
    }

    @Override
    public Class<TranslateLatinBelarusian> getAnnotationClass() {
        return TranslateLatinBelarusian.class;
    }
}
