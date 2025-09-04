package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TokiPonaProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTokiPona;

public class TranslateTokiPonaStrategy extends TranslationStrategy<TranslateTokiPona> {
    public TranslateTokiPonaStrategy() {
        super(TokiPonaProvider.class);
    }

    @Override
    public Class<? extends TranslateTokiPona> getAnnotationClass() {
        return TranslateTokiPona.class;
    }
}
