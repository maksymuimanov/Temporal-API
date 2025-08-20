package com.temporal.api.core.engine.io.context;

import java.util.List;

@FunctionalInterface
public interface ObjectPoolInitializer {
    void initialize(List<?> externalObjects);
}
