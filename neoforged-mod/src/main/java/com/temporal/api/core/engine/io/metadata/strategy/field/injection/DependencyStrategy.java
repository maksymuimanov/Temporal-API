package com.temporal.api.core.engine.io.metadata.strategy.field.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Dependency;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DependencyStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Dependency dependency = field.getDeclaredAnnotation(Dependency.class);
        field.setBoolean(object, ModList.get().isLoaded(dependency.value()));
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.putObject(object);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Dependency.class;
    }
}
