package com.temporal.api.core.engine.context;

public interface Context<K, C extends ObjectPool> {
    C getPool(K key);

    C createPool(K key);

    void removePool(K key);
}
