package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MexicanSpanishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMexicanSpanish;

public class TranslateMexicanSpanishStrategy extends TranslationStrategy<TranslateMexicanSpanish> {
    public TranslateMexicanSpanishStrategy() {
        super(MexicanSpanishProvider.class);
    }

    @Override
    public Class<? extends TranslateMexicanSpanish> getAnnotationClass() {
        return TranslateMexicanSpanish.class;
    }
}
