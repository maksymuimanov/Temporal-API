package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FrisianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFrisian;

public class TranslateFrisianStrategy extends TranslationStrategy<TranslateFrisian> {
    public TranslateFrisianStrategy() {
        super(FrisianProvider.class);
    }

    @Override
    public Class<? extends TranslateFrisian> getAnnotationClass() {
        return TranslateFrisian.class;
    }
}
