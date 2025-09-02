package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.IcelandicProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateIcelandic;

public class TranslateIcelandicStrategy extends TranslationStrategy<TranslateIcelandic> {
    public TranslateIcelandicStrategy() {
        super(IcelandicProvider.class);
    }

    @Override
    public Class<? extends TranslateIcelandic> getAnnotationClass() {
        return TranslateIcelandic.class;
    }
}
