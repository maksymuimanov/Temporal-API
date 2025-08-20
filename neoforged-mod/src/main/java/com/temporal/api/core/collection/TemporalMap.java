package com.temporal.api.core.collection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class TemporalMap<K, V> implements Map<K, V> {
    private final Map<K, V> delegate;
    private byte count;
    private final byte limit;

    public TemporalMap() {
        this((byte) 1);
    }

    public TemporalMap(byte limit) {
        this((byte) 0, limit);
    }

    public TemporalMap(byte count, byte limit) {
        this(new HashMap<>(), count, limit);
    }

    public TemporalMap(Map<K, V> delegate) {
        this(delegate, (byte) 1);
    }

    public TemporalMap(Map<K, V> delegate, byte limit) {
        this(delegate, (byte) 0, limit);
    }

    public TemporalMap(Map<K, V> delegate, byte count, byte limit) {
        this.delegate = delegate;
        this.count = count;
        this.limit = limit;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V v = delegate.get(key);
        this.remove(key);
        return v;
    }

    @Override
    public @Nullable V put(K key, V value) {
        return delegate.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return delegate.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        delegate.putAll(map);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public @NotNull Set<K> keySet() {
        return delegate.keySet();
    }

    @Override
    public @NotNull Collection<V> values() {
        return delegate.values();
    }

    @Override
    public @NotNull Set<Entry<K, V>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V v = delegate.getOrDefault(key, defaultValue);
        this.remove(key);
        return v;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        delegate.forEach(action);
        count++;
        if (count == limit) {
            this.clear();
            count = 0;
        }
    }
}
