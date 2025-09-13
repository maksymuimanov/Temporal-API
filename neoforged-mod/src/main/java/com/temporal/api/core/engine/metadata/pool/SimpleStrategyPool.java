package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleStrategyPool implements StrategyPool {
    private final Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> annotationStrategyMap;
    private final Map<StrategyScope, Set<Class<? extends Annotation>>> strategies;

    public SimpleStrategyPool() {
        this.annotationStrategyMap = new HashMap<>();
        this.strategies = new HashMap<>();
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name, String... names) {
        Map<Class<? extends Annotation>, R> strategyMap = this.getAll(name);
        for (String anotherName : names) {
            strategyMap.putAll(this.getAll(anotherName));
        }
        return strategyMap;
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name) {
        StrategyScope scope = this.strategies.keySet()
                .stream()
                .filter(s -> s.name().equals(name))
                .findAny()
                .orElseThrow();
        return this.getAll(scope);
    }

    @Override
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope, StrategyScope... scopes) {
        Map<Class<? extends Annotation>, R> strategyMap = this.getAll(scope);
        for (StrategyScope anotherScope : scopes) {
            strategyMap.putAll(this.getAll(anotherScope));
        }
        return strategyMap;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope) {
        Set<Class<? extends Annotation>> annotationClasses = this.strategies.get(scope);
        return annotationClasses.stream()
                .map(this.annotationStrategyMap::get)
                .map(strategy -> (R) strategy)
                .collect(Collectors.toMap(strategy -> strategy.getAnnotationClass(), strategy -> strategy));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, A extends Annotation, S extends AnnotationStrategy<T, A>> List<S> get(Class<? extends A> annotationClass) {
        return (List<S>) annotationStrategyMap.get(annotationClass);
    }

    @Override
    public void put(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategyClass) {
        AnnotationStrategy<?, ?> strategy = ReflectionUtils.createObject(strategyClass);
        this.put(scope, strategy);
    }

    @Override
    public <T, A extends Annotation, S extends AnnotationStrategy<T, A>> void put(StrategyScope scope, S strategy) {
        Class<? extends A> annotationClass = strategy.getAnnotationClass();
        MapUtils.putToListMap(this.annotationStrategyMap, annotationClass, strategy);
        MapUtils.putToSetMap(this.strategies, scope, annotationClass);
    }

    @Override
    public <T, A extends Annotation> void override(StrategyScope scope, Class<? extends AnnotationStrategy<T, A>> from, Class<? extends AnnotationStrategy<T, A>> to) {
        AnnotationStrategy<T, A> fromAnnotationStrategy = ReflectionUtils.createObject(from);
        AnnotationStrategy<T, A> toAnnotationStrategy = ReflectionUtils.createObject(to);
        this.override(scope, fromAnnotationStrategy, toAnnotationStrategy);
    }

    @Override
    public <T, A extends Annotation, FS extends AnnotationStrategy<T, A>, TS extends AnnotationStrategy<T, A>> void override(StrategyScope scope, FS from, TS to) {
        List<AnnotationStrategy<?, ?>> annotationStrategies = this.annotationStrategyMap.get(from.getAnnotationClass());
        annotationStrategies.remove(from);
        annotationStrategies.add(to);
        Set<Class<? extends Annotation>> classes = this.strategies.get(scope);
        classes.remove(from.getAnnotationClass());
        classes.remove(to.getAnnotationClass());
    }

    @Override
    public <A extends Annotation> void remove(Class<? extends A> annotationClass) {
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
        return this.annotationStrategyMap.values().stream().flatMap(List::stream).iterator();
    }

    public static SimpleStrategyPool getInstance() {
        return InjectionPool.getFromInstance(SimpleStrategyPool.class);
    }
}
