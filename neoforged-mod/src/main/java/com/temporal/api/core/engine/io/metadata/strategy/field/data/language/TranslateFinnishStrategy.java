package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateFinnish;
import com.temporal.api.core.event.data.language.provider.FinnishProvider;

public class TranslateFinnishStrategy extends TranslationStrategy<TranslateFinnish> {
    public TranslateFinnishStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public Class<? extends TranslateFinnish> getAnnotationClass() {
        return TranslateFinnish.class;
    }
}
