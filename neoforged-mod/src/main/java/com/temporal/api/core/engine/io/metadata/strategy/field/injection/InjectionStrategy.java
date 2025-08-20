package com.temporal.api.core.engine.io.metadata.strategy.field.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injection;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class InjectionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ObjectPool objectPool = InjectionPool.getInstance();
        field.set(object, objectPool.getObject(field.getType()));
        objectPool.putObject(object);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Injection.class;
    }
}
