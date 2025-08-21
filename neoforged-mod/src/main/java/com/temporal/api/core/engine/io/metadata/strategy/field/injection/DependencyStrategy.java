package com.temporal.api.core.engine.io.metadata.strategy.field.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Dependency;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DependencyStrategy implements FieldAnnotationStrategy<Dependency> {
    @Override
    public void execute(Field field, Object object, Dependency annotation) throws Exception {
        field.setBoolean(object, ModList.get().isLoaded(annotation.value()));
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.putObject(object);
    }

    @Override
    public Class<? extends Dependency> getAnnotationClass() {
        return Dependency.class;
    }
}
