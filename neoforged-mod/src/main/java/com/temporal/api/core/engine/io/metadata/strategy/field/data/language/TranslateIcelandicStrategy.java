package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateIcelandic;
import com.temporal.api.core.event.data.language.provider.IcelandicProvider;

public class TranslateIcelandicStrategy extends TranslationStrategy<TranslateIcelandic> {
    public TranslateIcelandicStrategy() {
        super(IcelandicProvider.class);
    }

    @Override
    public Class<? extends TranslateIcelandic> getAnnotationClass() {
        return TranslateIcelandic.class;
    }
}
