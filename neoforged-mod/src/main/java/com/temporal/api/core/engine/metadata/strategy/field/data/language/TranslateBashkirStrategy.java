package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.BashkirProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateBashkir;

public class TranslateBashkirStrategy extends TranslationStrategy<TranslateBashkir> {
    public TranslateBashkirStrategy() {
        super(BashkirProvider.class);
    }

    @Override
    public Class<? extends TranslateBashkir> getAnnotationClass() {
        return TranslateBashkir.class;
    }
}
