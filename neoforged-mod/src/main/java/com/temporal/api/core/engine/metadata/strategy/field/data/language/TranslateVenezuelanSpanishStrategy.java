package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.VenezuelanSpanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateVenezuelanSpanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateVenezuelanSpanishStrategy extends TranslationStrategy<TranslateVenezuelanSpanish> {
    public TranslateVenezuelanSpanishStrategy() {
        super(VenezuelanSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateVenezuelanSpanish> getAnnotationClass() {
        return TranslateVenezuelanSpanish.class;
    }
}
