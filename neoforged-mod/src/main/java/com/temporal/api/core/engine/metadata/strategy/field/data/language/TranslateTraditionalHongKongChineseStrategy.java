package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TraditionalHongKongChineseProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTraditionalHongKongChinese;

public class TranslateTraditionalHongKongChineseStrategy extends TranslationStrategy<TranslateTraditionalHongKongChinese> {
    public TranslateTraditionalHongKongChineseStrategy() {
        super(TraditionalHongKongChineseProvider.class);
    }

    @Override
    public Class<? extends TranslateTraditionalHongKongChinese> getAnnotationClass() {
        return TranslateTraditionalHongKongChinese.class;
    }
}
