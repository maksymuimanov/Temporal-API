package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LolcatProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLolcat;

public class TranslateLolcatStrategy extends TranslationStrategy<TranslateLolcat> {
    public TranslateLolcatStrategy() {
        super(LolcatProvider.class);
    }

    @Override
    public Class<? extends TranslateLolcat> getAnnotationClass() {
        return TranslateLolcat.class;
    }
}
