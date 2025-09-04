package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TatarProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTatar;

public class TranslateTatarStrategy extends TranslationStrategy<TranslateTatar> {
    public TranslateTatarStrategy() {
        super(TatarProvider.class);
    }

    @Override
    public Class<? extends TranslateTatar> getAnnotationClass() {
        return TranslateTatar.class;
    }
}
