package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BavarianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBavarian;

public class TranslateBavarianStrategy extends TranslationStrategy<TranslateBavarian> {
    public TranslateBavarianStrategy() {
        super(BavarianProvider.class);
    }

    @Override
    public Class<? extends TranslateBavarian> getAnnotationClass() {
        return TranslateBavarian.class;
    }
}
