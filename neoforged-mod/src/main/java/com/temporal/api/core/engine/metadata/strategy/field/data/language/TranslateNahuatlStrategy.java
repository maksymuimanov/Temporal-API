package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.NahuatlProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateNahuatl;

public class TranslateNahuatlStrategy extends TranslationStrategy<TranslateNahuatl> {
    public TranslateNahuatlStrategy() {
        super(NahuatlProvider.class);
    }

    @Override
    public Class<? extends TranslateNahuatl> getAnnotationClass() {
        return TranslateNahuatl.class;
    }
}
