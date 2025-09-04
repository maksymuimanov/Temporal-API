package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MacedonianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMacedonian;

public class TranslateMacedonianStrategy extends TranslationStrategy<TranslateMacedonian> {
    public TranslateMacedonianStrategy() {
        super(MacedonianProvider.class);
    }

    @Override
    public Class<? extends TranslateMacedonian> getAnnotationClass() {
        return TranslateMacedonian.class;
    }
}
