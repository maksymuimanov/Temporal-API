package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CatalanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCatalan;

public class TranslateCatalanStrategy extends TranslationStrategy<TranslateCatalan> {
    public TranslateCatalanStrategy() {
        super(CatalanProvider.class);
    }

    @Override
    public Class<? extends TranslateCatalan> getAnnotationClass() {
        return TranslateCatalan.class;
    }
}
