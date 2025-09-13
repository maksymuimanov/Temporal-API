package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public interface StrategyPool extends Iterable<AnnotationStrategy<?, ?>> {
    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name, String... names);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(String name);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope, StrategyScope... scopes);

    <T, S extends AnnotationStrategy<T, ?>, R extends S> Map<Class<? extends Annotation>, R> getAll(StrategyScope scope);

    <T, A extends Annotation, S extends AnnotationStrategy<T, A>> List<S> get(Class<? extends A> annotationClass);

    void put(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategyClass);

    <T, A extends Annotation, S extends AnnotationStrategy<T, A>> void put(StrategyScope scope, S strategy);

    <T, A extends Annotation> void override(StrategyScope scope, Class<? extends AnnotationStrategy<T, A>> from, Class<? extends AnnotationStrategy<T, A>> to);

    <T, A extends Annotation, FS extends AnnotationStrategy<T, A>, TS extends AnnotationStrategy<T, A>> void override(StrategyScope scope, FS from, TS to);

    <A extends Annotation> void remove(Class<? extends A> annotationClass);

    boolean contains(String name);

    boolean contains(StrategyScope scope);

    <A extends Annotation> boolean contains(Class<? extends A> annotationClass);
}
