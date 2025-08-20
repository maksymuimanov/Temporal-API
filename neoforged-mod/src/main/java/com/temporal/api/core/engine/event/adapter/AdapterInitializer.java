package com.temporal.api.core.engine.event.adapter;

public interface AdapterInitializer {
    void initialize();

    void initialize(boolean condition);
}
