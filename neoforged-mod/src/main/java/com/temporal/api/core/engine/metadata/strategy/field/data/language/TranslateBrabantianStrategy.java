package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BrabantianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBrabantian;

public class TranslateBrabantianStrategy extends TranslationStrategy<TranslateBrabantian> {
    public TranslateBrabantianStrategy() {
        super(BrabantianProvider.class);
    }

    @Override
    public Class<? extends TranslateBrabantian> getAnnotationClass() {
        return TranslateBrabantian.class;
    }
}
