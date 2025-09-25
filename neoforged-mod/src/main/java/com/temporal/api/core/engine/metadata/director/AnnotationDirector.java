package com.temporal.api.core.engine.metadata.director;

import com.temporal.api.ApiMod;

import java.util.Set;

public interface AnnotationDirector {
    default void directAll(Set<Class<?>> classes) {
        classes.forEach(clazz -> {
            try {
                direct(clazz);
                logScanning(clazz);
            } catch (Exception e) {
                logException(e, clazz);
                throw new RuntimeException(e);
            }
        });
    }

    void direct(Class<?> clazz) throws Exception;

    private void logScanning(Class<?> clazz) {
        ApiMod.LOGGER.info("Scanned: class - {}", clazz.getName());
    }

    private void logException(Exception e, Class<?> clazz) {
        ApiMod.LOGGER.warn("Scanning went wrong ({})! - {}", clazz.getName(), e.getMessage());
    }
}
