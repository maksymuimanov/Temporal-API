package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TzotzilProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTzotzil;

public class TranslateTzotzilStrategy extends TranslationStrategy<TranslateTzotzil> {
    public TranslateTzotzilStrategy() {
        super(TzotzilProvider.class);
    }

    @Override
    public Class<? extends TranslateTzotzil> getAnnotationClass() {
        return TranslateTzotzil.class;
    }
}
