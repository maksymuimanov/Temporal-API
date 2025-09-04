package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LojbanProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLojban;

public class TranslateLojbanStrategy extends TranslationStrategy<TranslateLojban> {
    public TranslateLojbanStrategy() {
        super(LojbanProvider.class);
    }

    @Override
    public Class<? extends TranslateLojban> getAnnotationClass() {
        return TranslateLojban.class;
    }
}
