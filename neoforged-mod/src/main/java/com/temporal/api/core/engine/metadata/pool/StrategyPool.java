package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

public interface StrategyPool {
    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(Collection<Class<? extends Annotation>> annotationClasses);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(Class<? extends Annotation> annotationClass, Class<? extends Annotation>... annotationClasses);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(String name, String... names);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(String name);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(StrategyScope scope, StrategyScope... scopes);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getStrategies(StrategyScope scope);

    <A extends Annotation, S extends AnnotationStrategy<?, A>> S getStrategy(Class<? extends A> annotationClass);

    void putStrategy(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategy);

    <A extends Annotation, S extends AnnotationStrategy<?, A>> void putStrategy(StrategyScope scope, S strategy);

    <A extends Annotation> void removeStrategy(Class<? extends A> annotationClass);

    boolean exists(String name);

    boolean exists(StrategyScope scope);

    <A extends Annotation> boolean exists(Class<? extends A> annotationClass);
}
