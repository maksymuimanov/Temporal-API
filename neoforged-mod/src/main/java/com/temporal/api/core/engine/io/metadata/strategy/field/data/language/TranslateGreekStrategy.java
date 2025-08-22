package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateGreek;
import com.temporal.api.core.event.data.language.provider.GreekProvider;

public class TranslateGreekStrategy extends TranslationStrategy<TranslateGreek> {
    public TranslateGreekStrategy() {
        super(GreekProvider.class);
    }

    @Override
    public Class<? extends TranslateGreek> getAnnotationClass() {
        return TranslateGreek.class;
    }
}
