package com.temporal.api.core.engine.context;

import java.util.List;

public interface ObjectPool {
    <T> T getObject(String key);

    <T> T getObject(Class<? extends T> key);

    InjectionKey getContextKey(String name);

    InjectionKey getContextKey(Class<?> clazz);

    <T> List<? extends T> getObjects(Class<T> commonInterface);

    List<?> getAllObjects();

    <T> void putObject(String keyName, Class<? extends T> keyClass);

    <T> void putObject(Class<? extends T> key);

    <T> void putObject(T value);

    <T> void putObject(String key, T value);

    <T> void putObject(Class<? extends T> key, T value);

    <T> void putObject(InjectionKey key, T value);

    <T> void removeObject(Class<? extends T> key);

    <T> void removeObject(T value);

    void removeAllObjects();
}
