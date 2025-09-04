package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LaoProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLao;

public class TranslateLaoStrategy extends TranslationStrategy<TranslateLao> {
    public TranslateLaoStrategy() {
        super(LaoProvider.class);
    }

    @Override
    public Class<? extends TranslateLao> getAnnotationClass() {
        return TranslateLao.class;
    }
}
