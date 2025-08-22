package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSlovak;
import com.temporal.api.core.event.data.language.provider.SlovakProvider;

public class TranslateSlovakStrategy extends TranslationStrategy<TranslateSlovak> {
    public TranslateSlovakStrategy() {
        super(SlovakProvider.class);
    }

    @Override
    public Class<? extends TranslateSlovak> getAnnotationClass() {
        return TranslateSlovak.class;
    }
}
