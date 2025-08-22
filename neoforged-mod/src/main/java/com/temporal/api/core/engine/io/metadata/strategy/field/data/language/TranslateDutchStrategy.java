package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateDutch;
import com.temporal.api.core.event.data.language.provider.DutchProvider;

public class TranslateDutchStrategy extends TranslationStrategy<TranslateDutch> {
    public TranslateDutchStrategy() {
        super(DutchProvider.class);
    }

    @Override
    public Class<? extends TranslateDutch> getAnnotationClass() {
        return TranslateDutch.class;
    }
}
