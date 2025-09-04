package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MalayProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMalay;

public class TranslateMalayStrategy extends TranslationStrategy<TranslateMalay> {
    public TranslateMalayStrategy() {
        super(MalayProvider.class);
    }

    @Override
    public Class<? extends TranslateMalay> getAnnotationClass() {
        return TranslateMalay.class;
    }
}
