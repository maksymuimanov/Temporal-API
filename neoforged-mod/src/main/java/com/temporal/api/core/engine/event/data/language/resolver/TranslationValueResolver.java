package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public interface TranslationValueResolver {
    String PLACEHOLDER_REGEX = "\\{(.*?)}";

    String resolve(String key, String value, Map<String, String> translationMap, Iterable<TranslationPlaceholderResolver> placeholderResolvers);
}
