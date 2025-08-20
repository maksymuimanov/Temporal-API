package com.temporal.api.core.engine.io.context;

import java.util.List;

public interface ObjectPool {
    <T> T getObject(String key);

    <T> T getObject(Class<? extends T> key);

    ContextKey getContextKey(String name);

    ContextKey getContextKey(Class<?> clazz);

    <T> List<? extends T> getObjects(Class<T> commonInterface);

    List<?> getAllObjects();

    <T> void putObject(Class<? extends T> key);

    <T> void putObject(T value);

    <T> void putObject(String key, T value);

    <T> void putObject(Class<? extends T> key, T value);

    <T> void putObject(ContextKey key, T value);

    <T> void removeObject(Class<? extends T> key);

    <T> void removeObject(T value);

    void removeAllObjects();
}
