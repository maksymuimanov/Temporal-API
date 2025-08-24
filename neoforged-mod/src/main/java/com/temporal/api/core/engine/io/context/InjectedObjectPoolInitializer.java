package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import net.neoforged.fml.ModList;

import java.util.List;

public class InjectedObjectPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(List<?> externalObjects) {
        IOLayer.NEO_MOD.getClasses()
                .forEach(clazz -> {
                    Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
                    String modCondition = annotation.mandatoryMod();
                    if (annotation.value() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition))) {
                        ObjectPool objectPool = InjectionPool.getInstance();
                        objectPool.putObject(clazz);
                    }
                });
    }
}
