package com.temporal.api.core.json.formatter;

public interface JsonFormatter<R> {
    R format(String baseJson, Object... arguments);
}
