package com.temporal.api.core.engine.event.data.language.resolver;

public interface PlaceholderResolver {
    String resolve(String body, String... arguments);
}
