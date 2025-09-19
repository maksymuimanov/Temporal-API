package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.TraditionalHongKongChineseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateTraditionalHongKongChinese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTraditionalHongKongChineseStrategy extends TranslationStrategy<TranslateTraditionalHongKongChinese> {
    public TranslateTraditionalHongKongChineseStrategy() {
        super(TraditionalHongKongChineseProvider.class);
    }

    @Override
    public Class<TranslateTraditionalHongKongChinese> getAnnotationClass() {
        return TranslateTraditionalHongKongChinese.class;
    }
}
