package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public class ThisTranslationPlaceholderResolver implements TranslationPlaceholderResolver {
    public static final String REGEX = "^this\\d$|^\\dthis$|^\\dthis\\d$|^this\\$$|^\\$this$|^\\$this\\$$";
    public static final String PLACEHOLDER_IDENTIFIER = "this";
    public static final String KEY_DELIMITER_REGEX = "\\.";
    public static final String KEY_DELIMITER = ".";
    public static final char KEYS_WITHOUT = '$';

    @Override
    public String resolve(String key, String placeholder, Map<String, String> translationMap) {
        if (!placeholder.matches(REGEX)) return placeholder;
        String[] keys = key.split(KEY_DELIMITER_REGEX);
        int start = 0;
        int end = keys.length;
        boolean afterThis = false;
        char[] chars = placeholder.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            boolean isKeysWithout = aChar == KEYS_WITHOUT;
            boolean isDigit = Character.isDigit(aChar);
            if (!afterThis) {
                if (isKeysWithout) {
                    start++;
                } else if (isDigit) {
                    start = Integer.parseInt(String.valueOf(aChar));
                } else if (aChar == PLACEHOLDER_IDENTIFIER.charAt(0)) {
                    i += PLACEHOLDER_IDENTIFIER.length() - 1;
                    afterThis = true;
                }
            } else {
                if (isKeysWithout) {
                    end--;
                } else if (isDigit) {
                    end = Integer.parseInt(String.valueOf(aChar));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(keys[i]);
            if (i != end - 1) result.append(KEY_DELIMITER);
        }
        String translationValue = translationMap.get(result.toString());
        return translationValue.isBlank() ? placeholder : translationValue;
    }
}