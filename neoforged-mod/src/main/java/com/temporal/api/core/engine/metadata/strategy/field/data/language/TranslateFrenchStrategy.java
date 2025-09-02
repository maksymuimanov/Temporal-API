package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FrenchProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFrench;

public class TranslateFrenchStrategy extends TranslationStrategy<TranslateFrench> {
    public TranslateFrenchStrategy() {
        super(FrenchProvider.class);
    }

    @Override
    public Class<? extends TranslateFrench> getAnnotationClass() {
        return TranslateFrench.class;
    }
}
