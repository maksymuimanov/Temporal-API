package com.temporal.api.core.engine.context;

import java.util.List;
import java.util.function.Predicate;

public interface ObjectPool extends Iterable<Object> {
    <T> List<? extends T> getAll(Class<T> commonInterface);

    List<?> getAll();

    <T> T get(String name);

    <T> T get(Class<? extends T> key);

    <T> T get(InjectionKey key);

    InjectionKey getKey(String name);

    InjectionKey getKey(Class<?> clazz);

    InjectionKey getKey(Predicate<? super InjectionKey> predicate);

    <T> void put(String name, Class<? extends T> clazz);

    <T> void put(Class<? extends T> clazz);

    <T> void put(T value);

    <T> void put(String key, T value);

    <T> void put(Class<? extends T> key, T value);

    <T> void put(InjectionKey key, T value);

    <T> void remove(Class<? extends T> key);

    <T> void remove(T value);

    void clear();

    boolean contains(String name);

    boolean contains(Class<?> clazz);

    boolean contains(InjectionKey key);
}
