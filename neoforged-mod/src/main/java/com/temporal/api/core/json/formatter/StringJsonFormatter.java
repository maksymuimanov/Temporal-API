package com.temporal.api.core.json.formatter;

public class StringJsonFormatter implements JsonFormatter<String> {
    @Override
    public String format(String baseJson, Object... arguments) {
        if (arguments == null || arguments.length == 0) return baseJson;
        StringBuilder result = new StringBuilder();
        boolean isOpen = false;
        int index = 0;
        char[] chars = baseJson.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '$' && chars[i + 1] == '{') {
                isOpen = true;
                result.append(arguments[index].toString());
                continue;
            } else if (isOpen && chars[i] == '}') {
                isOpen = false;
                index++;
                continue;
            }

            if (!isOpen) {
                result.append(chars[i]);
            }
        }

        return result.toString();
    }
}
