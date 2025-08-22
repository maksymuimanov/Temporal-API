package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateIrish;
import com.temporal.api.core.event.data.language.provider.IrishProvider;

public class TranslateIrishStrategy extends TranslationStrategy<TranslateIrish> {
    public TranslateIrishStrategy() {
        super(IrishProvider.class);
    }

    @Override
    public Class<? extends TranslateIrish> getAnnotationClass() {
        return TranslateIrish.class;
    }
}
