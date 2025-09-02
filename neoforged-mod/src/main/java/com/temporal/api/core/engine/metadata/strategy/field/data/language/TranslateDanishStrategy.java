package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.DanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateDanish;

public class TranslateDanishStrategy extends TranslationStrategy<TranslateDanish> {
    public TranslateDanishStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public Class<? extends TranslateDanish> getAnnotationClass() {
        return TranslateDanish.class;
    }
}
