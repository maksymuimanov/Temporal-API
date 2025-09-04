package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatinSerbianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatinSerbian;

public class TranslateLatinSerbianStrategy extends TranslationStrategy<TranslateLatinSerbian> {
    public TranslateLatinSerbianStrategy() {
        super(LatinSerbianProvider.class);
    }

    @Override
    public Class<? extends TranslateLatinSerbian> getAnnotationClass() {
        return TranslateLatinSerbian.class;
    }
}
