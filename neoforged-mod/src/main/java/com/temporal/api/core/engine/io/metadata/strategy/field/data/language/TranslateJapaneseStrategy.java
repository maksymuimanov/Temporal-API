package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateJapanese;
import com.temporal.api.core.event.data.language.provider.JapaneseProvider;

public class TranslateJapaneseStrategy extends TranslationStrategy<TranslateJapanese> {
    public TranslateJapaneseStrategy() {
        super(JapaneseProvider.class);
    }

    @Override
    public Class<? extends TranslateJapanese> getAnnotationClass() {
        return TranslateJapanese.class;
    }
}
