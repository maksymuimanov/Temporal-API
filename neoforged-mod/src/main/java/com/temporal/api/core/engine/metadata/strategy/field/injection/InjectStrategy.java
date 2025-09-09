package com.temporal.api.core.engine.metadata.strategy.field.injection;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.injection.Inject;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION)
public class InjectStrategy implements FieldAnnotationStrategy<Inject> {
    @Override
    public void execute(Field field, Object object, Inject annotation) throws Exception {
        ObjectPool objectPool = InjectionPool.getInstance();
        String beanName = annotation.value();
        Object poolObject = beanName.isBlank() ? objectPool.get(field.getType()) : objectPool.get(beanName);
        field.set(object, poolObject);
        Class<?> objectClass = object.getClass();
        Injected injected = objectClass.getDeclaredAnnotation(Injected.class);
        if (!injected.isContextObject()) throw new IllegalStateException("@Inject annotation can be applied if class is annotated with @Injected(isContextObject=true)");
        String rootBeanName = injected.value();
        if (rootBeanName.isBlank()) {
            objectPool.put(objectClass);
        } else {
            objectPool.put(rootBeanName, objectClass);
        }
    }

    @Override
    public Class<? extends Inject> getAnnotationClass() {
        return Inject.class;
    }
}
