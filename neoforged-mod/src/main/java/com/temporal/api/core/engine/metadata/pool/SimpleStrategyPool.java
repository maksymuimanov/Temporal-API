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
    public Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(String name, String... names) {
        Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> strategyMap = this.getAll(name);
        for (String anotherName : names) {
            strategyMap.putAll(this.getAll(anotherName));
        }
        return strategyMap;
    }

    @Override
    public Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(String name) {
        StrategyScope scope = this.strategies.keySet()
                .stream()
                .filter(s -> s.name().equals(name))
                .findAny()
                .orElseThrow();
        return this.getAll(scope);
    }

    @Override
    public Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(StrategyScope scope, StrategyScope... scopes) {
        Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> strategyMap = this.getAll(scope);
        for (StrategyScope anotherScope : scopes) {
            strategyMap.putAll(this.getAll(anotherScope));
        }
        return strategyMap;
    }

    @Override
    public Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(StrategyScope scope) {
        Set<Class<? extends Annotation>> annotationClasses = this.strategies.get(scope);
        return annotationClasses.stream()
                .map(this.annotationStrategyMap::get)
                .collect(Collectors.toMap(strategyList -> strategyList.getFirst().getAnnotationClass(), strategyList -> strategyList));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, A extends Annotation> AnnotationStrategy<T, A> get(Class<A> annotationClass, Class<? super T> typeClass) {
        return this.get(annotationClass)
                .stream()
                .filter(strategy -> strategy.getTypeClass().equals(typeClass))
                .findAny()
                .map(strategy -> (AnnotationStrategy<T, A>) strategy)
                .orElseThrow();
    }

    @Override
    public List<AnnotationStrategy<?, ?>> get(Class<? extends Annotation> annotationClass) {
        return annotationStrategyMap.get(annotationClass);
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
    public void override(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> from, Class<? extends AnnotationStrategy<?, ?>> to) {
        AnnotationStrategy<?, ?> fromAnnotationStrategy = ReflectionUtils.createObject(from);
        AnnotationStrategy<?, ?> toAnnotationStrategy = ReflectionUtils.createObject(to);
        this.override(scope, fromAnnotationStrategy, toAnnotationStrategy);
    }

    @Override
    public void override(StrategyScope scope, AnnotationStrategy<?, ?> from, AnnotationStrategy<?, ?> to) {
        List<AnnotationStrategy<?, ?>> annotationStrategies = this.annotationStrategyMap.get(from.getAnnotationClass());
        annotationStrategies.parallelStream()
                .filter(annotationStrategy -> annotationStrategy.getClass().equals(from.getClass()))
                .findAny()
                .ifPresent(annotationStrategy -> {
                    annotationStrategies.remove(annotationStrategy);
                    annotationStrategies.add(to);
                    Set<Class<? extends Annotation>> classes = this.strategies.get(scope);
                    classes.remove(annotationStrategy.getAnnotationClass());
                    classes.add(to.getAnnotationClass());
                });
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
    public <T, A extends Annotation> boolean contains(Class<? extends A> annotationClass, Class<? super T> typeClass) {
        List<AnnotationStrategy<?, ?>> list = this.annotationStrategyMap.get(annotationClass);
        return list != null && !list.isEmpty() && list.stream().anyMatch(strategy -> strategy.getTypeClass().equals(typeClass));
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
