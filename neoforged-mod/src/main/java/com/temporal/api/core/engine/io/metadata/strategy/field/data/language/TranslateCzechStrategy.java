package com.temporal.api.core.engine.io.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateCzech;
import com.temporal.api.core.event.data.language.provider.CzechProvider;

public class TranslateCzechStrategy extends TranslationStrategy<TranslateCzech> {
    public TranslateCzechStrategy() {
        super(CzechProvider.class);
    }

    @Override
    public Class<? extends TranslateCzech> getAnnotationClass() {
        return TranslateCzech.class;
    }
}
