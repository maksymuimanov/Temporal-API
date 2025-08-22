package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateFrench;
import com.temporal.api.core.event.data.language.provider.FrenchProvider;

public class TranslateFrenchStrategy extends TranslationStrategy<TranslateFrench> {
    public TranslateFrenchStrategy() {
        super(FrenchProvider.class);
    }

    @Override
    public Class<? extends TranslateFrench> getAnnotationClass() {
        return TranslateFrench.class;
    }
}
