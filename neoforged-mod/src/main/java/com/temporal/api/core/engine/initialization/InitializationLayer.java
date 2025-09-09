package com.temporal.api.core.engine.initialization;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.context.NeoMod;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.initialization.initializer.ObjectPoolInitializer;
import com.temporal.api.core.engine.initialization.scanner.ModClassScanner;

import java.util.List;
import java.util.Set;

public class InitializationLayer implements EngineLayer {
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectPoolInitializer> objectPoolInitializers;
    private List<?> externalSource;

    @Override
    public void processAllTasks() {
        NeoMod mod = NeoMod.create(this.modClass, this.classScanners);
        String modId = mod.getModId();
        Set<Class<?>> classes = mod.getClasses();
        ModContext.NEO_MOD = mod;
        ModContext.ALL_CLASSES.addAll(classes);
        ApiMod.LOGGER.info("NeoMod dependency created: (modId={}, classes={})", modId, classes.size());
        ObjectPool objectPool = ModContext.getInstance()
                .createPool(modId);
        ApiMod.LOGGER.debug("ObjectPool created for modId: {}", modId);
        objectPoolInitializers.forEach(initializer -> {
            ApiMod.LOGGER.debug("Running defaulted ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(objectPool, this.externalSource);
        });
        objectPool.getAll(ObjectPoolInitializer.class).forEach(initializer -> {
            ApiMod.LOGGER.debug("Running dynamic ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(objectPool, this.externalSource);
        });
    }

    public void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }

    public void setClassScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
    }

    public void setContextInitializers(List<ObjectPoolInitializer> objectPoolInitializers) {
        this.objectPoolInitializers = objectPoolInitializers;
    }

    public void setExternalSource(List<?> externalSource) {
        this.externalSource = externalSource;
    }
}
