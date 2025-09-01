package com.temporal.api.core.file.formatter;

public class StringFileContentFormatter implements FileContentFormatter<String> {
    @Override
    public String format(String body, Object... arguments) {
        if (arguments == null || arguments.length == 0) return body;
        StringBuilder result = new StringBuilder();
        boolean isOpen = false;
        int index = 0;
        char[] chars = body.toCharArray();
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
