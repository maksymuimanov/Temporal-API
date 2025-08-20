package com.temporal.api.core.engine.io.context;

public interface Context<K, C extends ObjectPool> {
    C getPool(K key);

    C createPool(K key);

    void removePool(K key);
}
