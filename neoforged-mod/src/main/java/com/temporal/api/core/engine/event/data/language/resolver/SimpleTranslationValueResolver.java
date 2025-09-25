package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTranslationValueResolver implements TranslationValueResolver {
    @Override
    public String resolve(String key, String value, Map<String, String> translationMap, Iterable<TranslationPlaceholderResolver> placeholderResolvers) {
        if (!value.contains("{") || !value.contains("}") || translationMap == null || translationMap.isEmpty()) return value;
        StringBuilder result = new StringBuilder(value);
        Pattern pattern = Pattern.compile(PLACEHOLDER_REGEX);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            String placeholder = group.substring(1, group.length() - 1);
            for (TranslationPlaceholderResolver resolver : placeholderResolvers) {
                placeholder = resolver.resolve(key, placeholder, translationMap);
            }
            result.replace(start, end, placeholder);
        }
        return result.toString();
    }
}