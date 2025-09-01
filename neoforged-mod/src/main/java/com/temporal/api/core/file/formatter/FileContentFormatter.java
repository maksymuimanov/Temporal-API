package com.temporal.api.core.file.formatter;

public interface FileContentFormatter<R> {
    R format(String body, Object... arguments);
}
