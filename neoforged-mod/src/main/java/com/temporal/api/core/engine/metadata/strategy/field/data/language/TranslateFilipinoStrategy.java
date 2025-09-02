package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FilipinoProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFilipino;

public class TranslateFilipinoStrategy extends TranslationStrategy<TranslateFilipino> {
    public TranslateFilipinoStrategy() {
        super(FilipinoProvider.class);
    }

    @Override
    public Class<? extends TranslateFilipino> getAnnotationClass() {
        return TranslateFilipino.class;
    }
}
