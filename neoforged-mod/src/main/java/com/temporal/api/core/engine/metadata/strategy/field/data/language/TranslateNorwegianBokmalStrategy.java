package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NorwegianBokmalProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNorwegianBokmal;

public class TranslateNorwegianBokmalStrategy extends TranslationStrategy<TranslateNorwegianBokmal> {
    public TranslateNorwegianBokmalStrategy() {
        super(NorwegianBokmalProvider.class);
    }

    @Override
    public Class<? extends TranslateNorwegianBokmal> getAnnotationClass() {
        return TranslateNorwegianBokmal.class;
    }
}
