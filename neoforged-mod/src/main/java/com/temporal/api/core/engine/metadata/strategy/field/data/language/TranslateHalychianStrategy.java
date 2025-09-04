package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.HalychianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateHalychian;

public class TranslateHalychianStrategy extends TranslationStrategy<TranslateHalychian> {
    public TranslateHalychianStrategy() {
        super(HalychianProvider.class);
    }

    @Override
    public Class<? extends TranslateHalychian> getAnnotationClass() {
        return TranslateHalychian.class;
    }
}
