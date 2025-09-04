package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NorwegianNynorskProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNorwegianNynorsk;

public class TranslateNorwegianNynorskStrategy extends TranslationStrategy<TranslateNorwegianNynorsk> {
    public TranslateNorwegianNynorskStrategy() {
        super(NorwegianNynorskProvider.class);
    }

    @Override
    public Class<? extends TranslateNorwegianNynorsk> getAnnotationClass() {
        return TranslateNorwegianNynorsk.class;
    }
}
