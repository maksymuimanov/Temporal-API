package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateAlbanian;
import com.temporal.api.core.event.data.language.provider.AlbanianProvider;

public class TranslateAlbanianStrategy extends TranslationStrategy<TranslateAlbanian> {
    public TranslateAlbanianStrategy() {
        super(AlbanianProvider.class);
    }

    @Override
    public Class<? extends TranslateAlbanian> getAnnotationClass() {
        return TranslateAlbanian.class;
    }
}
