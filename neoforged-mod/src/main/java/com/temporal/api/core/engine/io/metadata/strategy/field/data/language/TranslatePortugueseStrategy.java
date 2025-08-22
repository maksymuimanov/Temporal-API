package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslatePortuguese;
import com.temporal.api.core.event.data.language.provider.PortugueseProvider;

public class TranslatePortugueseStrategy extends TranslationStrategy<TranslatePortuguese> {
    public TranslatePortugueseStrategy() {
        super(PortugueseProvider.class);
    }

    @Override
    public Class<? extends TranslatePortuguese> getAnnotationClass() {
        return TranslatePortuguese.class;
    }
}
