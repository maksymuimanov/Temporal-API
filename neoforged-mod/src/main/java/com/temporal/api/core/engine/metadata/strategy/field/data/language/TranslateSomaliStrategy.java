package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SomaliProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSomali;

public class TranslateSomaliStrategy extends TranslationStrategy<TranslateSomali> {
    public TranslateSomaliStrategy() {
        super(SomaliProvider.class);
    }

    @Override
    public Class<? extends TranslateSomali> getAnnotationClass() {
        return TranslateSomali.class;
    }
}
