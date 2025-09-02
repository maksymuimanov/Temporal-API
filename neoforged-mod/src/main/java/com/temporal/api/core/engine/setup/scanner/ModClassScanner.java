package com.temporal.api.core.engine.setup.scanner;

import java.util.Set;

public interface ModClassScanner {
    void getClasses(String modId, Class<?> modClass, Set<Class<?>> target);
}
