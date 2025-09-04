package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MongolianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMongolian;

public class TranslateMongolianStrategy extends TranslationStrategy<TranslateMongolian> {
    public TranslateMongolianStrategy() {
        super(MongolianProvider.class);
    }

    @Override
    public Class<? extends TranslateMongolian> getAnnotationClass() {
        return TranslateMongolian.class;
    }
}
