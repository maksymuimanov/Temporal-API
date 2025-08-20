package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.reflect.Field;

public interface FieldAnnotationStrategy extends AnnotationStrategy<Field> {
    void execute(Field field, Object object) throws Exception;
}
