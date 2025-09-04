package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LombardProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLombard;

public class TranslateLombardStrategy extends TranslationStrategy<TranslateLombard> {
    public TranslateLombardStrategy() {
        super(LombardProvider.class);
    }

    @Override
    public Class<? extends TranslateLombard> getAnnotationClass() {
        return TranslateLombard.class;
    }
}
