package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateTurkish;
import com.temporal.api.core.event.data.language.provider.TurkishProvider;

public class TranslateTurkishStrategy extends TranslationStrategy<TranslateTurkish> {
    public TranslateTurkishStrategy() {
        super(TurkishProvider.class);
    }

    @Override
    public Class<? extends TranslateTurkish> getAnnotationClass() {
        return TranslateTurkish.class;
    }
}
