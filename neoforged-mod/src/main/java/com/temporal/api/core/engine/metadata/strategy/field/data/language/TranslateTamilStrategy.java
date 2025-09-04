package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TamilProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTamil;

public class TranslateTamilStrategy extends TranslationStrategy<TranslateTamil> {
    public TranslateTamilStrategy() {
        super(TamilProvider.class);
    }

    @Override
    public Class<? extends TranslateTamil> getAnnotationClass() {
        return TranslateTamil.class;
    }
}
