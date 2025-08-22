package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateFilipino;
import com.temporal.api.core.event.data.language.provider.FilipinoProvider;

public class TranslateFilipinoStrategy extends TranslationStrategy<TranslateFilipino> {
    public TranslateFilipinoStrategy() {
        super(FilipinoProvider.class);
    }

    @Override
    public Class<? extends TranslateFilipino> getAnnotationClass() {
        return TranslateFilipino.class;
    }
}
