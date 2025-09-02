package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.CroatianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateCroatian;

public class TranslateCroatianStrategy extends TranslationStrategy<TranslateCroatian> {
    public TranslateCroatianStrategy() {
        super(CroatianProvider.class);
    }

    @Override
    public Class<? extends TranslateCroatian> getAnnotationClass() {
        return TranslateCroatian.class;
    }
}
