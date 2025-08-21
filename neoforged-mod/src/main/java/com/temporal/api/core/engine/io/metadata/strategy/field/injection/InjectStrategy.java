package com.temporal.api.core.engine.io.metadata.strategy.field.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Inject;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class InjectStrategy implements FieldAnnotationStrategy<Inject> {
    @Override
    public void execute(Field field, Object object, Inject annotation) throws Exception {
        ObjectPool objectPool = InjectionPool.getInstance();
        field.set(object, objectPool.getObject(field.getType()));
        objectPool.putObject(object);
    }

    @Override
    public Class<? extends Inject> getAnnotationClass() {
        return Inject.class;
    }
}
