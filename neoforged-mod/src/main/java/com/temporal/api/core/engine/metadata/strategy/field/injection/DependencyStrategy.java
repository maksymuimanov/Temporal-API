package com.temporal.api.core.engine.metadata.strategy.field.injection;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.injection.Dependency;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION)
public class DependencyStrategy implements FieldAnnotationStrategy<Dependency> {
    @Override
    public void execute(Field field, Object object, Dependency annotation) throws Exception {
        field.setBoolean(object, ModList.get().isLoaded(annotation.value()));
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.put(object);
    }

    @Override
    public Class<? extends Dependency> getAnnotationClass() {
        return Dependency.class;
    }
}
