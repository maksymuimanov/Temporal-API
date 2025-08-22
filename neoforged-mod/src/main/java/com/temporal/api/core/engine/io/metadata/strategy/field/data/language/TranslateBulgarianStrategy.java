package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateBulgarian;
import com.temporal.api.core.event.data.language.provider.BulgarianProvider;

public class TranslateBulgarianStrategy extends TranslationStrategy<TranslateBulgarian> {
    public TranslateBulgarianStrategy() {
        super(BulgarianProvider.class);
    }

    @Override
    public Class<? extends TranslateBulgarian> getAnnotationClass() {
        return TranslateBulgarian.class;
    }
}
