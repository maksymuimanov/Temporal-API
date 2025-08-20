package com.temporal.api.core.engine.io.metadata.strategy.type.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.annotation.Annotation;

public class InjectedStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        Injected injected = clazz.getDeclaredAnnotation(Injected.class);
        String modCondition = injected.mandatoryMod();
        if (injected.value() && injected.isInjection() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition))) {
            ObjectPool objectPool = InjectionPool.getInstance();
            objectPool.putObject(clazz);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Injected.class;
    }
}
