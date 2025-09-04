package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.LatinBelarusianProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateLatinBelarusian;

public class TranslateLatinBelarusianStrategy extends TranslationStrategy<TranslateLatinBelarusian> {
    public TranslateLatinBelarusianStrategy() {
        super(LatinBelarusianProvider.class);
    }

    @Override
    public Class<? extends TranslateLatinBelarusian> getAnnotationClass() {
        return TranslateLatinBelarusian.class;
    }
}
