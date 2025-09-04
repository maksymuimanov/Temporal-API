package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ShakespeareanEnglishProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateShakespeareanEnglish;

public class TranslateShakespeareanEnglishStrategy extends TranslationStrategy<TranslateShakespeareanEnglish> {
    public TranslateShakespeareanEnglishStrategy() {
        super(ShakespeareanEnglishProvider.class);
    }

    @Override
    public Class<? extends TranslateShakespeareanEnglish> getAnnotationClass() {
        return TranslateShakespeareanEnglish.class;
    }
}
