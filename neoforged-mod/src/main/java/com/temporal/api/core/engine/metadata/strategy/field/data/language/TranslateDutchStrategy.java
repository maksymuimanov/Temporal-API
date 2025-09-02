package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.DutchProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateDutch;

public class TranslateDutchStrategy extends TranslationStrategy<TranslateDutch> {
    public TranslateDutchStrategy() {
        super(DutchProvider.class);
    }

    @Override
    public Class<? extends TranslateDutch> getAnnotationClass() {
        return TranslateDutch.class;
    }
}
