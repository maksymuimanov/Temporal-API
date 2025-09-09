package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import net.neoforged.fml.ModList;

import java.util.List;

public class InjectedObjectPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        ModContext.NEO_MOD.getClasses()
                .forEach(clazz -> {
                    if (!clazz.isAnnotationPresent(Injected.class)) return;
                    Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
                    String modCondition = annotation.mandatoryMod();
                    if (annotation.isContextObject() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition))) {
                        String beanName = annotation.value();
                        if (beanName.isBlank()) {
                            objectPool.put(clazz);
                        } else {
                            objectPool.put(beanName, clazz);
                        }
                    }
                });
    }
}
