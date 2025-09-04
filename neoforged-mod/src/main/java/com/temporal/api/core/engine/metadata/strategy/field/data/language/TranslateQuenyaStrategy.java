package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.QuenyaProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateQuenya;

public class TranslateQuenyaStrategy extends TranslationStrategy<TranslateQuenya> {
    public TranslateQuenyaStrategy() {
        super(QuenyaProvider.class);
    }

    @Override
    public Class<? extends TranslateQuenya> getAnnotationClass() {
        return TranslateQuenya.class;
    }
}
