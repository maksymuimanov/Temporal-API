package com.temporal.api.core.engine.event.data.language.resolver;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class ThisTranslationPlaceholderResolver implements TranslationPlaceholderResolver {
    public static final String REGEX = "^this\\d+$|^this\\*$|^this\\$$";
    public static final String PLACEHOLDER_IDENTIFIER = "this";
    public static final String KEY_DELIMITER_REGEX = "\\.";
    public static final String KEY_DELIMITER = ".";
    public static final String KEYS_WITHOUT_LAST = "$";

    @Override
    public String resolve(String key, String placeholder, Map<String, String> translationMap) {
        if (!placeholder.matches(REGEX)) return placeholder;
        String[] keys = key.split(KEY_DELIMITER_REGEX);
        String thisValue = placeholder.replace(PLACEHOLDER_IDENTIFIER, "");
        int length = 0;
        if (StringUtils.isNumeric(thisValue)) {
            length = Integer.parseInt(thisValue);
        } else if (KEYS_WITHOUT_LAST.equals(thisValue)) {
            length = keys.length - 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(keys[i]);
            if (i != length - 1) result.append(KEY_DELIMITER);
        }
        String translationValue = translationMap.get(result.toString());
        return translationValue.isBlank() ? placeholder : translationValue;
    }
}