package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IrishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIrish;

public class TranslateIrishStrategy extends TranslationStrategy<TranslateIrish> {
    public TranslateIrishStrategy() {
        super(IrishProvider.class);
    }

    @Override
    public Class<? extends TranslateIrish> getAnnotationClass() {
        return TranslateIrish.class;
    }
}
