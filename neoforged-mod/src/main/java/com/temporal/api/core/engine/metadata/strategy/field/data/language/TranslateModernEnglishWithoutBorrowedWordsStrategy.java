package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ModernEnglishWithoutBorrowedWordsProvider;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateModernEnglishWithoutBorrowedWords;

public class TranslateModernEnglishWithoutBorrowedWordsStrategy extends TranslationStrategy<TranslateModernEnglishWithoutBorrowedWords> {
    public TranslateModernEnglishWithoutBorrowedWordsStrategy() {
        super(ModernEnglishWithoutBorrowedWordsProvider.class);
    }

    @Override
    public Class<? extends TranslateModernEnglishWithoutBorrowedWords> getAnnotationClass() {
        return TranslateModernEnglishWithoutBorrowedWords.class;
    }
}
