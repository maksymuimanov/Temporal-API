package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateDanish;
import com.temporal.api.core.event.data.language.provider.DanishProvider;

public class TranslateDanishStrategy extends TranslationStrategy<TranslateDanish> {
    public TranslateDanishStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public Class<? extends TranslateDanish> getAnnotationClass() {
        return TranslateDanish.class;
    }
}
