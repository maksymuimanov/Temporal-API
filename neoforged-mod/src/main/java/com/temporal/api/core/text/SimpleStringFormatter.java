package com.temporal.api.core.text;

public class SimpleStringFormatter implements StringFormatter {
    @Override
    public String format(String body, String... arguments) {
        if (arguments == null || arguments.length == 0) return body;
        StringBuilder result = new StringBuilder();
        boolean isOpen = false;
        int index = 0;
        char[] chars = body.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '$' && chars[i + 1] == '{') {
                isOpen = true;
                result.append(arguments[index]);
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
