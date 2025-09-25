package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public interface TranslationPlaceholderResolver {
    String resolve(String key, String placeholder, Map<String, String> translationMap);
}
