package com.temporal.api.core.engine.io.context;

import java.util.Set;

public interface ModClassScanner {
    void getClasses(String modId, Class<?> modClass, Set<Class<?>> target);
}
