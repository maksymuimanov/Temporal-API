package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateSlovenian;
import com.temporal.api.core.event.data.language.provider.SlovenianProvider;

public class TranslateSlovenianStrategy extends TranslationStrategy<TranslateSlovenian> {
    public TranslateSlovenianStrategy() {
        super(SlovenianProvider.class);
    }

    @Override
    public Class<? extends TranslateSlovenian> getAnnotationClass() {
        return TranslateSlovenian.class;
    }
}
