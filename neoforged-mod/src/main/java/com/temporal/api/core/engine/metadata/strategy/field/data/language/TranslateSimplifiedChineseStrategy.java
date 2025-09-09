package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.SimplifiedChineseProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateSimplifiedChinese;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSimplifiedChineseStrategy extends TranslationStrategy<TranslateSimplifiedChinese> {
    public TranslateSimplifiedChineseStrategy() {
        super(SimplifiedChineseProvider.class);
    }

    @Override
    public Class<? extends TranslateSimplifiedChinese> getAnnotationClass() {
        return TranslateSimplifiedChinese.class;
    }
}
