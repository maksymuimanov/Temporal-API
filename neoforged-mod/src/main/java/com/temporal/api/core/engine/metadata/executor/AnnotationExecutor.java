package com.temporal.api.core.engine.metadata.executor;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

public interface AnnotationExecutor<S extends AnnotationStrategy<?, ?>> {
    default void tryExecute(S strategy, Class<?> clazz) {
        try {
            execute(strategy, clazz);
            logScanning(strategy, clazz);
        } catch (Exception e) {
            logException(e, strategy, clazz);
            throw new RuntimeException(e);
        }
    }

    void execute(S strategy, Class<?> clazz) throws Exception;

    private void logScanning(S strategy, Class<?> clazz) {
        ApiMod.LOGGER.info("Scanned: class - {}, strategy - {}", clazz.getSimpleName(), strategy.getClass().getName());
    }

    private void logException(Exception e, S strategy, Class<?> clazz) {
        ApiMod.LOGGER.warn("Scanning went wrong ({}:{})! - {}", clazz.getSimpleName(), e.getMessage(), strategy.getClass().getName());
    }
}
