package com.temporal.api.core.compat;

import com.temporal.api.core.engine.event.handler.EventHandler;

public interface DependencyProcessBuilder<B extends DependencyProcessBuilder<B>> {
    B addProcess(EventHandler eventHandler);

    B addProcess(DependencyFunction callback);

    B startNext(String dependencyId, String... additionalDependencyIds);

    void build();
}
