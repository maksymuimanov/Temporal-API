package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CanadianFrenchProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCanadianFrench;

public class TranslateCanadianFrenchStrategy extends TranslationStrategy<TranslateCanadianFrench> {
    public TranslateCanadianFrenchStrategy() {
        super(CanadianFrenchProvider.class);
    }

    @Override
    public Class<? extends TranslateCanadianFrench> getAnnotationClass() {
        return TranslateCanadianFrench.class;
    }
}
