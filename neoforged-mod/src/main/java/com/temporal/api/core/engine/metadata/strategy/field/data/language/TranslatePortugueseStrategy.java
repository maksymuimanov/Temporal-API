package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PortugueseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePortuguese;

public class TranslatePortugueseStrategy extends TranslationStrategy<TranslatePortuguese> {
    public TranslatePortugueseStrategy() {
        super(PortugueseProvider.class);
    }

    @Override
    public Class<? extends TranslatePortuguese> getAnnotationClass() {
        return TranslatePortuguese.class;
    }
}
