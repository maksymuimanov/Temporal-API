package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.AlbanianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAlbanian;

public class TranslateAlbanianStrategy extends TranslationStrategy<TranslateAlbanian> {
    public TranslateAlbanianStrategy() {
        super(AlbanianProvider.class);
    }

    @Override
    public Class<? extends TranslateAlbanian> getAnnotationClass() {
        return TranslateAlbanian.class;
    }
}
