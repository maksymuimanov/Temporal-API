package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UpperSaxonGermanProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUpperSaxonGerman;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUpperSaxonGermanStrategy extends TranslationStrategy<TranslateUpperSaxonGerman> {
    public TranslateUpperSaxonGermanStrategy() {
        super(UpperSaxonGermanProvider.class);
    }

    @Override
    public Class<TranslateUpperSaxonGerman> getAnnotationClass() {
        return TranslateUpperSaxonGerman.class;
    }
}
