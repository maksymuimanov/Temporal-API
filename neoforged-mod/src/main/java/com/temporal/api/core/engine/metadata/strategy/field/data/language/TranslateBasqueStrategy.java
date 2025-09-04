package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BasqueProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBasque;

public class TranslateBasqueStrategy extends TranslationStrategy<TranslateBasque> {
    public TranslateBasqueStrategy() {
        super(BasqueProvider.class);
    }

    @Override
    public Class<? extends TranslateBasque> getAnnotationClass() {
        return TranslateBasque.class;
    }
}
