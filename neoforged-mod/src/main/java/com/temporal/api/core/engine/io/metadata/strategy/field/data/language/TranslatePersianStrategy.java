package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslatePersian;
import com.temporal.api.core.event.data.language.provider.PersianProvider;

public class TranslatePersianStrategy extends TranslationStrategy<TranslatePersian> {
    public TranslatePersianStrategy() {
        super(PersianProvider.class);
    }

    @Override
    public Class<? extends TranslatePersian> getAnnotationClass() {
        return TranslatePersian.class;
    }
}
