package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.KyrgyzProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateKyrgyz;

public class TranslateKyrgyzStrategy extends TranslationStrategy<TranslateKyrgyz> {
    public TranslateKyrgyzStrategy() {
        super(KyrgyzProvider.class);
    }

    @Override
    public Class<? extends TranslateKyrgyz> getAnnotationClass() {
        return TranslateKyrgyz.class;
    }
}
