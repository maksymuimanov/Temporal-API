package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateAustrianGerman;
import com.temporal.api.core.event.data.language.provider.AustrianGermanProvider;

public class TranslateAustrianGermanStrategy extends TranslationStrategy<TranslateAustrianGerman> {
    public TranslateAustrianGermanStrategy() {
        super(AustrianGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateAustrianGerman> getAnnotationClass() {
        return TranslateAustrianGerman.class;
    }
}
