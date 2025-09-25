package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public interface StrategyPool extends Iterable<AnnotationStrategy<?, ?>> {
    Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(String name, String... names);

    Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(String name);

    Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(StrategyScope scope, StrategyScope... scopes);

    Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> getAll(StrategyScope scope);

    <T, A extends Annotation> AnnotationStrategy<T, A> get(Class<A> annotationClass, Class<? super T> typeClass);

    List<AnnotationStrategy<?, ?>> get(Class<? extends Annotation> annotationClass);

    void put(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> strategyClass);

    <T, A extends Annotation, S extends AnnotationStrategy<T, A>> void put(StrategyScope scope, S strategy);

    void override(StrategyScope scope, Class<? extends AnnotationStrategy<?, ?>> from, Class<? extends AnnotationStrategy<?, ?>> to);

    void override(StrategyScope scope, AnnotationStrategy<?, ?> from, AnnotationStrategy<?, ?> to);

    <A extends Annotation> void remove(Class<? extends A> annotationClass);

    boolean contains(String name);

    boolean contains(StrategyScope scope);

    <T, A extends Annotation> boolean contains(Class<? extends A> annotationClass, Class<? super T> typeClass);

    <A extends Annotation> boolean contains(Class<? extends A> annotationClass);
}
