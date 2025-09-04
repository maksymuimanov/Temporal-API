package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.MalteseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMaltese;

public class TranslateMalteseStrategy extends TranslationStrategy<TranslateMaltese> {
    public TranslateMalteseStrategy() {
        super(MalteseProvider.class);
    }

    @Override
    public Class<? extends TranslateMaltese> getAnnotationClass() {
        return TranslateMaltese.class;
    }
}
