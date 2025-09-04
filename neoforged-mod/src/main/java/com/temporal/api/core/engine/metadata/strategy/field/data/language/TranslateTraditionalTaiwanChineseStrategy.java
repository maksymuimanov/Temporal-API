package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TraditionalTaiwanChineseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTraditionalTaiwanChinese;

public class TranslateTraditionalTaiwanChineseStrategy extends TranslationStrategy<TranslateTraditionalTaiwanChinese> {
    public TranslateTraditionalTaiwanChineseStrategy() {
        super(TraditionalTaiwanChineseProvider.class);
    }

    @Override
    public Class<? extends TranslateTraditionalTaiwanChinese> getAnnotationClass() {
        return TranslateTraditionalTaiwanChinese.class;
    }
}
