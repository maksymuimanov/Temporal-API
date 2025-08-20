package com.temporal.api.core.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class TemporalBiMap<K, V> implements BiMap<K, V> {
    private final BiMap<K, V> delegate;
    private byte count;
    private final byte limit;

    public TemporalBiMap() {
        this((byte) 1);
    }

    public TemporalBiMap(byte limit) {
        this((byte) 0, limit);
    }

    public TemporalBiMap(byte count, byte limit) {
        this(HashBiMap.create(), count, limit);
    }

    public TemporalBiMap(BiMap<K, V> delegate) {
        this(delegate, (byte) 1);
    }

    public TemporalBiMap(BiMap<K, V> delegate, byte limit) {
        this(delegate, (byte) 0, limit);
    }

    public TemporalBiMap(BiMap<K, V> delegate, byte count, byte limit) {
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
    public V remove(Object key) {
        return delegate.remove(key);
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
    public @Nullable V put(K key, V value) {
        return delegate.put(key, value);
    }

    @Override
    public @Nullable V forcePut(K key, V value) {
        return delegate.forcePut(key, value);
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        delegate.putAll(map);
    }

    @Override
    public @NotNull Set<V> values() {
        return delegate.values();
    }

    @Override
    public @NotNull BiMap<V, K> inverse() {
        return delegate.inverse();
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
