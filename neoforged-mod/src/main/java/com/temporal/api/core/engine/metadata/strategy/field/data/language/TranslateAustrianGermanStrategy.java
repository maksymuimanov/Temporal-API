package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AustrianGermanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAustrianGerman;

public class TranslateAustrianGermanStrategy extends TranslationStrategy<TranslateAustrianGerman> {
    public TranslateAustrianGermanStrategy() {
        super(AustrianGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateAustrianGerman> getAnnotationClass() {
        return TranslateAustrianGerman.class;
    }
}
