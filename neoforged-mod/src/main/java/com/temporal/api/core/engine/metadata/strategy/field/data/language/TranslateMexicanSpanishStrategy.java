package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MexicanSpanishProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMexicanSpanish;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMexicanSpanishStrategy extends TranslationStrategy<TranslateMexicanSpanish> {
    public TranslateMexicanSpanishStrategy() {
        super(MexicanSpanishProvider.class);
    }

    @Override
    public Class<TranslateMexicanSpanish> getAnnotationClass() {
        return TranslateMexicanSpanish.class;
    }
}
