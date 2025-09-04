package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.FaroeseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateFaroese;

public class TranslateFaroeseStrategy extends TranslationStrategy<TranslateFaroese> {
    public TranslateFaroeseStrategy() {
        super(FaroeseProvider.class);
    }

    @Override
    public Class<? extends TranslateFaroese> getAnnotationClass() {
        return TranslateFaroese.class;
    }
}
