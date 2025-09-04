package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PirateEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePirateEnglish;

public class TranslatePirateEnglishStrategy extends TranslationStrategy<TranslatePirateEnglish> {
    public TranslatePirateEnglishStrategy() {
        super(PirateEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslatePirateEnglish> getAnnotationClass() {
        return TranslatePirateEnglish.class;
    }
}
