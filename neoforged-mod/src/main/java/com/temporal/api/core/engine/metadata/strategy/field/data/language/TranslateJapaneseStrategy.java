package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.JapaneseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateJapanese;

public class TranslateJapaneseStrategy extends TranslationStrategy<TranslateJapanese> {
    public TranslateJapaneseStrategy() {
        super(JapaneseProvider.class);
    }

    @Override
    public Class<? extends TranslateJapanese> getAnnotationClass() {
        return TranslateJapanese.class;
    }
}
