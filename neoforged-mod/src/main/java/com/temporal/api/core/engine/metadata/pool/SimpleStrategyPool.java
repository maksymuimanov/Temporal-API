package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.util.MapUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
        return this.getStrategies(annotationClasses.toArray(Class[]::new));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(Class<? extends Annotation>... annotationClasses) {
        Map<Class<? extends Annotation>, R> strategies = new HashMap<>();
        for (Class<? extends Annotation> annotationClass : annotationClasses) {
            R strategy = (R) this.getStrategy(annotationClass);
            strategies.put(annotationClass, strategy);
        }
        return strategies;
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
    public boolean exists(String name) {
        return this.strategies.keySet()
                .stream()
                .anyMatch(s -> s.name().equals(name));
    }

    @Override
    public boolean exists(StrategyScope scope) {
        return this.strategies.containsKey(scope);
    }

    @Override
    public <A extends Annotation> boolean exists(Class<? extends A> annotationClass) {
        return this.annotationStrategyMap.containsKey(annotationClass);
    }

    public static SimpleStrategyPool getInstance() {
        return InjectionPool.getFromInstance(SimpleStrategyPool.class);
    }
}
