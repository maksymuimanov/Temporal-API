package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FinnishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFinnish;

public class TranslateFinnishStrategy extends TranslationStrategy<TranslateFinnish> {
    public TranslateFinnishStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public Class<? extends TranslateFinnish> getAnnotationClass() {
        return TranslateFinnish.class;
    }
}
