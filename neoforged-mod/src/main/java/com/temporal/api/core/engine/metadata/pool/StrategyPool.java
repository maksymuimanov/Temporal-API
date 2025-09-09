package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

public interface StrategyPool extends Iterable<AnnotationStrategy<?, ?>> {
    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(Collection<Class<? extends Annotation>> annotationClasses);

    @SuppressWarnings("unchecked")
    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(Class<? extends Annotation> annotationClass, Class<? extends Annotation>... annotationClasses);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name, String... names);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope, StrategyScope... scopes);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope);

    <A extends Annotation, S extends AnnotationStrategy<?, A>> S get(Class<? extends A> annotationClass);

    void put(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategy);

    <A extends Annotation, S extends AnnotationStrategy<?, A>> void put(StrategyScope scope, S strategy);

    <A extends Annotation> void remove(Class<? extends A> annotationClass);

    boolean contains(String name);

    boolean contains(StrategyScope scope);

    <A extends Annotation> boolean contains(Class<? extends A> annotationClass);
}
