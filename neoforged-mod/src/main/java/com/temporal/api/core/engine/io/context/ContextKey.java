package com.temporal.api.core.engine.io.context;

public final class ContextKey {
    private String name;
    private Class<?> clazz;

    public ContextKey(Class<?> clazz) {
        this(clazz.getSimpleName(), clazz);
    }

    public ContextKey(String name, Class<?> clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
