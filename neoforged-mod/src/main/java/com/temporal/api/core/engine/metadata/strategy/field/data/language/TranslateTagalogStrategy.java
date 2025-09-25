package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TagalogProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTagalog;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTagalogStrategy extends TranslationStrategy<TranslateTagalog> {
    public TranslateTagalogStrategy() {
        super(TagalogProvider.class);
    }

    @Override
    public Class<TranslateTagalog> getAnnotationClass() {
        return TranslateTagalog.class;
    }
}
