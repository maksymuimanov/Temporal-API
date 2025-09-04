package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LiteraryChineseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLiteraryChinese;

public class TranslateLiteraryChineseStrategy extends TranslationStrategy<TranslateLiteraryChinese> {
    public TranslateLiteraryChineseStrategy() {
        super(LiteraryChineseProvider.class);
    }

    @Override
    public Class<? extends TranslateLiteraryChinese> getAnnotationClass() {
        return TranslateLiteraryChinese.class;
    }
}
