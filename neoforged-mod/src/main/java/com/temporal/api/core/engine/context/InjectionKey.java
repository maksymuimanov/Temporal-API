package com.temporal.api.core.engine.context;

public final class InjectionKey {
    private String name;
    private Class<?> clazz;

    public InjectionKey(Class<?> clazz) {
        this(clazz.getSimpleName(), clazz);
    }

    public InjectionKey(String name, Class<?> clazz) {
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
