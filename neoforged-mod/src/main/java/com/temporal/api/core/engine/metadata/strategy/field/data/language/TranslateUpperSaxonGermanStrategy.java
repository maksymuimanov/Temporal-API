package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.UpperSaxonGermanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateUpperSaxonGerman;

public class TranslateUpperSaxonGermanStrategy extends TranslationStrategy<TranslateUpperSaxonGerman> {
    public TranslateUpperSaxonGermanStrategy() {
        super(UpperSaxonGermanProvider.class);
    }

    @Override
    public Class<? extends TranslateUpperSaxonGerman> getAnnotationClass() {
        return TranslateUpperSaxonGerman.class;
    }
}
