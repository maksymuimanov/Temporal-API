package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import net.neoforged.fml.ModList;

import java.util.List;

public class InjectedObjectPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        IOLayer.NEO_MOD.getClasses()
                .forEach(clazz -> {
                    if (!clazz.isAnnotationPresent(Injected.class)) return;
                    Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
                    String modCondition = annotation.mandatoryMod();
                    if (annotation.value() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition))) {
                        objectPool.putObject(clazz);
                    }
                });
    }
}
