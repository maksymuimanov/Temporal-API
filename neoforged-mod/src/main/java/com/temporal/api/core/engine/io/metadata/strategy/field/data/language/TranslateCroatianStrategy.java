package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateCroatian;
import com.temporal.api.core.event.data.language.provider.CroatianProvider;

public class TranslateCroatianStrategy extends TranslationStrategy<TranslateCroatian> {
    public TranslateCroatianStrategy() {
        super(CroatianProvider.class);
    }

    @Override
    public Class<? extends TranslateCroatian> getAnnotationClass() {
        return TranslateCroatian.class;
    }
}
