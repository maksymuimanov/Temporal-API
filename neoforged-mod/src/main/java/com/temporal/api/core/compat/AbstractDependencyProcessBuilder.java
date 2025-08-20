package com.temporal.api.core.compat;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDependencyProcessBuilder<B extends AbstractDependencyProcessBuilder<B>> implements DependencyProcessBuilder<B> {
    private final List<String> dependencyIds;
    private final List<DependencyFunction> callbacks = new ArrayList<>();

    protected AbstractDependencyProcessBuilder(List<String> dependencyIds) {
        this.dependencyIds = dependencyIds;
    }

    protected List<String> getDependencyIds() {
        return dependencyIds;
    }

    protected List<DependencyFunction> getCallbacks() {
        return callbacks;
    }

    protected void addCallback(DependencyFunction callback) {
        callbacks.add(callback);
    }
}
