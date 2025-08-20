package com.temporal.api.core.engine.io.metadata.executor;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.stream.Collectors;

public interface AnnotationExecutor<S extends AnnotationStrategy<?>> {
    default void tryExecute(Map<Class<? extends Annotation>, S> strategies, Class<?> clazz) {
        try {
            execute(strategies, clazz);
            logScanning(strategies, clazz);
        } catch (Exception e) {
            logException(e, strategies, clazz);
            throw new RuntimeException(e);
        }
    }

    void execute(Map<Class<? extends Annotation>, S> strategies, Class<?> clazz) throws Exception;

    private void logScanning(Map<Class<? extends Annotation>, S> strategies, Class<?> clazz) {
        ApiMod.LOGGER.info("Scanned: class - {}, annotations - {}", clazz.getSimpleName(), strategies.keySet()
                .stream()
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", ")));
    }

    private void logException(Exception e, Map<Class<? extends Annotation>, S> strategies, Class<?> clazz) {
        ApiMod.LOGGER.warn("Scanning went wrong ({}:{})! - {}", clazz.getSimpleName(), e.getMessage(), strategies.keySet()
                .stream()
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", ")));
    }
}
