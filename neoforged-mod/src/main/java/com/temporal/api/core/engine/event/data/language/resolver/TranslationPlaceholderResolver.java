package com.temporal.api.core.engine.event.data.language.resolver;

import java.util.Map;

public interface TranslationPlaceholderResolver {
    String resolve(String value, Map<String, String> translationMap);
}
