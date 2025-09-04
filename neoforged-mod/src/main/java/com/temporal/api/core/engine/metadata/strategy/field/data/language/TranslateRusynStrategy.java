package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.RusynProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateRusyn;

public class TranslateRusynStrategy extends TranslationStrategy<TranslateRusyn> {
    public TranslateRusynStrategy() {
        super(RusynProvider.class);
    }

    @Override
    public Class<? extends TranslateRusyn> getAnnotationClass() {
        return TranslateRusyn.class;
    }
}
