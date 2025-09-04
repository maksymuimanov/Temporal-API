package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.GalicianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateGalician;

public class TranslateGalicianStrategy extends TranslationStrategy<TranslateGalician> {
    public TranslateGalicianStrategy() {
        super(GalicianProvider.class);
    }

    @Override
    public Class<? extends TranslateGalician> getAnnotationClass() {
        return TranslateGalician.class;
    }
}
