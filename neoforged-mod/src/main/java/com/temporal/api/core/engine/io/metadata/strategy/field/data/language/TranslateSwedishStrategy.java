package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSwedish;
import com.temporal.api.core.event.data.language.provider.SwedishProvider;

public class TranslateSwedishStrategy extends TranslationStrategy<TranslateSwedish> {
    public TranslateSwedishStrategy() {
        super(SwedishProvider.class);
    }

    @Override
    public Class<? extends TranslateSwedish> getAnnotationClass() {
        return TranslateSwedish.class;
    }
}
