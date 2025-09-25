package com.temporal.api.core.engine.context;

import com.temporal.api.core.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class InjectionPool implements ObjectPool {
    private final Map<InjectionKey, Object> objects;
    private final Map<String, InjectionKey> cachedNames;
    private final Map<Class<?>, InjectionKey> cachedClasses;

    protected InjectionPool() {
        this.objects = new HashMap<>();
        this.cachedNames = new ConcurrentHashMap<>();
        this.cachedClasses = new ConcurrentHashMap<>();
    }

    @Override
    public <T> List<? extends T> getAll(Class<T> commonInterface) {
        return this.objects.values()
                .stream()
                .filter(commonInterface::isInstance)
                .map(commonInterface::cast)
                .toList();
    }

    @Override
    public List<?> getAll() {
        return this.objects.values()
                .stream()
                .toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        InjectionKey key = this.getKey(name);
        return (T) this.objects.get(key);
    }

    @Override
    public <T> T get(Class<? extends T> key) {
        Object object = this.objects.get(this.getKey(key));
        if (object == null) {
            List<? extends T> list = this.getAll(key);
            if (!list.isEmpty()) object = list.getFirst();
        }

        return key.cast(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(InjectionKey key) {
        return (T) this.objects.get(key);
    }

    @Override
    public InjectionKey getKey(String name) {
        return cachedNames.computeIfAbsent(name, (id) ->
                this.getKey(key -> id.equals(key.getName())));
    }

    @Override
    public InjectionKey getKey(Class<?> clazz) {
        return cachedClasses.computeIfAbsent(clazz, (id) ->
                this.getKey(key -> id.equals(key.getClazz())));
    }

    @Override
    public InjectionKey getKey(Predicate<? super InjectionKey> predicate) {
        return this.objects.keySet()
                .stream()
                .filter(predicate)
                .findAny()
                .orElse(null);
    }

    @Override
    public <T> void put(String name, Class<? extends T> clazz) {
        T value = ReflectionUtils.createObject(clazz);
        this.put(name, value);
    }

    @Override
    public <T> void put(Class<? extends T> clazz) {
        T value = ReflectionUtils.createObject(clazz);
        this.put(clazz, value);
    }

    @Override
    public <T> void put(T value) {
        this.put(value.getClass(), value);
    }

    @Override
    public <T> void put(String key, T value) {
        this.put(new InjectionKey(key, value.getClass()), value);
    }

    @Override
    public <T> void put(Class<? extends T> key, T value) {
        this.put(new InjectionKey(key), value);
    }

    @Override
    public <T> void put(InjectionKey key, T value) {
        this.objects.put(key, value);
        this.cachedNames.put(key.getName(), key);
        this.cachedClasses.put(key.getClazz(), key);
    }

    @Override
    public <T> void remove(Class<? extends T> key) {
        InjectionKey injectionKey = this.getKey(key);
        this.objects.remove(injectionKey);
        this.cachedNames.remove(injectionKey.getName());
        this.cachedClasses.remove(key);
    }

    @Override
    public <T> void remove(T value) {
        this.remove(value.getClass());
    }

    @Override
    public void clear() {
        this.objects.clear();
        this.cachedNames.clear();
        this.cachedClasses.clear();
    }

    @Override
    public boolean contains(String name) {
        return this.cachedNames.containsKey(name) || this.contains(this.getKey(name));
    }

    @Override
    public boolean contains(Class<?> clazz) {
        return this.cachedClasses.containsKey(clazz) || this.contains(this.getKey(clazz));
    }

    @Override
    public boolean contains(InjectionKey key) {
        return this.objects.containsKey(key);
    }

    public static <T> T getFromInstance(String key) {
        ObjectPool objectPool = InjectionPool.getInstance();
        return objectPool.get(key);
    }

    public static <T> T getFromInstance(Class<? extends T> key) {
        ObjectPool objectPool = InjectionPool.getInstance();
        return objectPool.get(key);
    }

    public static InjectionPool getInstance() {
        return ModContext.getInstance()
                .getPool(ModContext.NEO_MOD.getModId());
    }

    @Override
    @NotNull
    public Iterator<Object> iterator() {
        return this.objects.values().iterator();
    }
}
