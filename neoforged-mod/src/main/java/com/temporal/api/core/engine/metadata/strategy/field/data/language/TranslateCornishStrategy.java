package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CornishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCornish;

public class TranslateCornishStrategy extends TranslationStrategy<TranslateCornish> {
    public TranslateCornishStrategy() {
        super(CornishProvider.class);
    }

    @Override
    public Class<? extends TranslateCornish> getAnnotationClass() {
        return TranslateCornish.class;
    }
}
