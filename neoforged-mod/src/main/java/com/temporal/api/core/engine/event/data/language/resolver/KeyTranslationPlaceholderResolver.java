package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public class KeyTranslationPlaceholderResolver implements TranslationPlaceholderResolver {
    public static final String REGEX = "^(\\w+\\.?)+\\w+$";

    @Override
    public String resolve(String key, String placeholder, Map<String, String> translationMap) {
        if (!placeholder.matches(REGEX)) return placeholder;
        String translationValue = translationMap.get(placeholder);
        return translationValue.isBlank() ? placeholder : translationValue;
    }
}