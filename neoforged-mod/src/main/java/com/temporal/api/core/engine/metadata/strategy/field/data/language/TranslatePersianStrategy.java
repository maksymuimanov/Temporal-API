package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.PersianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslatePersian;

public class TranslatePersianStrategy extends TranslationStrategy<TranslatePersian> {
    public TranslatePersianStrategy() {
        super(PersianProvider.class);
    }

    @Override
    public Class<? extends TranslatePersian> getAnnotationClass() {
        return TranslatePersian.class;
    }
}
