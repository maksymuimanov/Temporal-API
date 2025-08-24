package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class InjectionPool implements ObjectPool {
    private final Map<ContextKey, Object> objects;
    private final Map<String, ContextKey> cachedNames;
    private final Map<Class<?>, ContextKey> cachedClasses;

    protected InjectionPool() {
        this.objects = new HashMap<>();
        this.cachedNames = new ConcurrentHashMap<>();
        this.cachedClasses = new ConcurrentHashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getObject(String key) {
        ContextKey contextKey = this.getContextKey(key);
        return (T) this.objects.get(contextKey);
    }

    @Override
    public <T> T getObject(Class<? extends T> key) {
        Object object = this.objects.get(this.getContextKey(key));
        if (object == null) {
            List<? extends T> list = this.getObjects(key);
            if (!list.isEmpty()) object = list.getFirst();
        }

        return key.cast(object);
    }

    @Override
    public ContextKey getContextKey(String name) {
        return cachedNames.computeIfAbsent(name, (id) ->
                this.getContextKey(key -> id.equals(key.getName())));
    }

    @Override
    public ContextKey getContextKey(Class<?> clazz) {
        return cachedClasses.computeIfAbsent(clazz, (id) ->
                this.getContextKey(key -> id.equals(key.getClazz())));

    }

    @Override
    public <T> List<? extends T> getObjects(Class<T> commonInterface) {
        return this.objects.values()
                .stream()
                .filter(commonInterface::isInstance)
                .map(commonInterface::cast)
                .toList();
    }

    @Override
    public List<?> getAllObjects() {
        return this.objects.values()
                .stream()
                .toList();
    }

    @Override
    public <T> void putObject(Class<? extends T> key) {
        try {
            Constructor<? extends T> constructor = key.getDeclaredConstructor();
            T value = constructor.newInstance();
            this.putObject(key, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> void putObject(T value) {
        this.putObject(value.getClass(), value);
    }

    @Override
    public <T> void putObject(String key, T value) {
        this.putObject(new ContextKey(key, value.getClass()), value);
    }

    @Override
    public <T> void putObject(Class<? extends T> key, T value) {
        this.putObject(new ContextKey(key), value);
    }

    @Override
    public <T> void putObject(ContextKey key, T value) {
        this.objects.put(key, value);
        this.cachedNames.put(key.getName(), key);
        this.cachedClasses.put(key.getClazz(), key);
    }

    @Override
    public <T> void removeObject(Class<? extends T> key) {
        ContextKey contextKey = this.getContextKey(key);
        this.objects.remove(contextKey);
        this.cachedNames.remove(contextKey.getName());
        this.cachedClasses.remove(key);
    }

    @Override
    public <T> void removeObject(T value) {
        this.removeObject(value.getClass());
    }

    @Override
    public void removeAllObjects() {
        this.objects.clear();
        this.cachedNames.clear();
        this.cachedClasses.clear();
    }

    private ContextKey getContextKey(Predicate<? super ContextKey> predicate) {
        return this.objects.keySet()
                .stream()
                .filter(predicate)
                .findAny()
                .orElse(null);
    }

    public static <T> T getFromInstance(String key) {
        ObjectPool objectPool = InjectionPool.getInstance();
        return objectPool.getObject(key);
    }

    public static <T> T getFromInstance(Class<? extends T> key) {
        ObjectPool objectPool = InjectionPool.getInstance();
        return objectPool.getObject(key);
    }

    public static InjectionPool getInstance() {
        return ModContext.getInstance()
                .getPool(IOLayer.NEO_MOD.getModId());
    }
}
