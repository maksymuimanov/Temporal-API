package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GreekProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGreek;

public class TranslateGreekStrategy extends TranslationStrategy<TranslateGreek> {
    public TranslateGreekStrategy() {
        super(GreekProvider.class);
    }

    @Override
    public Class<? extends TranslateGreek> getAnnotationClass() {
        return TranslateGreek.class;
    }
}
