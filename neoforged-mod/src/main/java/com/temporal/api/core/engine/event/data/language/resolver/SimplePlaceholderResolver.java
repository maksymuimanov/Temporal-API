package com.temporal.api.core.engine.event.data.language.resolver;

public class SimplePlaceholderResolver implements PlaceholderResolver {
    //TODO
    @Override
    public String resolve(String body, String... arguments) {
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
