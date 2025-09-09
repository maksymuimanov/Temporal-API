package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleStrategyPool implements StrategyPool {
    private final Map<Class<? extends Annotation>, AnnotationStrategy<?, ?>> annotationStrategyMap;
    private final Map<StrategyScope, Set<Class<? extends Annotation>>> strategies;

    public SimpleStrategyPool() {
        this.annotationStrategyMap = new  HashMap<>();
        this.strategies = new HashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(Collection<Class<? extends Annotation>> annotationClasses) {
        Map<Class<? extends Annotation>, R> strategies = new HashMap<>();
        for (Class<? extends Annotation> anotherAnnotationClass : annotationClasses) {
            R anotherAnnotationStrategy = (R) this.getStrategy(anotherAnnotationClass);
            strategies.put(anotherAnnotationClass, anotherAnnotationStrategy);
        }
        return strategies;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(Class<? extends Annotation> annotationClass, Class<? extends Annotation>... annotationClasses) {
        Map<Class<? extends Annotation>, R> strategies = new HashMap<>();
        R annotationStrategy = (R) this.getStrategy(annotationClass);
        strategies.put(annotationClass, annotationStrategy);
        for (Class<? extends Annotation> anotherAnnotationClass : annotationClasses) {
            R anotherAnnotationStrategy = (R) this.getStrategy(anotherAnnotationClass);
            strategies.put(anotherAnnotationClass, anotherAnnotationStrategy);
        }
        return strategies;
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(String name, String... names) {
        Map<Class<? extends Annotation>, R> strategyMap = this.getStrategies(name);
        for (String anotherName : names) {
            strategyMap.putAll(this.getStrategies(anotherName));
        }
        return strategyMap;
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(String name) {
        StrategyScope scope = this.strategies.keySet()
                .stream()
                .filter(s -> s.name().equals(name))
                .findAny()
                .orElseThrow();
        return this.getStrategies(scope);
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(StrategyScope scope, StrategyScope... scopes) {
        Map<Class<? extends Annotation>, R> strategyMap = this.getStrategies(scope);
        for (StrategyScope anotherScope : scopes) {
            strategyMap.putAll(this.getStrategies(anotherScope));
        }
        return strategyMap;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(StrategyScope scope) {
        Set<Class<? extends Annotation>> annotationClasses = this.strategies.get(scope);
        return annotationClasses.stream()
                .map(this.annotationStrategyMap::get)
                .map(strategy -> (R) strategy)
                .collect(Collectors.toMap(strategy -> strategy.getAnnotationClass(), strategy -> strategy));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A extends Annotation, S extends AnnotationStrategy<?, A>> S getStrategy(Class<? extends A> annotationClass) {
        return (S) annotationStrategyMap.get(annotationClass);
    }

    @Override
    public void putStrategy(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategy) {
        try {
            Constructor<? extends AnnotationStrategy<?, ?>> constructor = strategy.getDeclaredConstructor();
            constructor.setAccessible(true);
            AnnotationStrategy<?, ?> t = constructor.newInstance();
            this.putStrategy(scope, t);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <A extends Annotation, S extends AnnotationStrategy<?, A>> void putStrategy(StrategyScope scope, S strategy) {
        Class<? extends A> annotationClass = strategy.getAnnotationClass();
        this.annotationStrategyMap.put(annotationClass, strategy);
        MapUtils.putToSetMap(this.strategies, scope, annotationClass);
    }

    @Override
    public <A extends Annotation> void removeStrategy(Class<? extends A> annotationClass) {
        this.annotationStrategyMap.remove(annotationClass);
        this.strategies.forEach((scope, annotations) -> annotations.remove(annotationClass));
    }

    @Override
    public boolean contains(String name) {
        return this.strategies.keySet()
                .stream()
                .anyMatch(s -> s.name().equals(name));
    }

    @Override
    public boolean contains(StrategyScope scope) {
        return this.strategies.containsKey(scope);
    }

    @Override
    public <A extends Annotation> boolean contains(Class<? extends A> annotationClass) {
        return this.annotationStrategyMap.containsKey(annotationClass);
    }

    @Override
    @NotNull
    public Iterator<AnnotationStrategy<?, ?>> iterator() {
        return this.annotationStrategyMap.values().iterator();
    }

    public static SimpleStrategyPool getInstance() {
        return InjectionPool.getFromInstance(SimpleStrategyPool.class);
    }
}
