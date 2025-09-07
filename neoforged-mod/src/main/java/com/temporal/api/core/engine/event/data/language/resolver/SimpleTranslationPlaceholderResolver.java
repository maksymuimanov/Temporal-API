package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public class SimpleTranslationPlaceholderResolver implements TranslationPlaceholderResolver {
    @Override
    public String resolve(String value, Map<String, String> translationMap) {
        if (!value.contains("{") || translationMap == null || translationMap.isEmpty()) return value;
        StringBuilder result = new StringBuilder();
        boolean isOpen = false;
        char[] chars = value.toCharArray();
        StringBuilder placeholder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '{') {
                isOpen = true;
                continue;
            } else if (isOpen && aChar == '}') {
                isOpen = false;
                String translationKey = placeholder.toString();
                result.append(translationMap.get(translationKey));
                placeholder = new StringBuilder();
                continue;
            } else if (isOpen) {
                placeholder.append(aChar);
            }

            if (!isOpen) {
                result.append(aChar);
            }
        }

        return result.toString();
    }
}
