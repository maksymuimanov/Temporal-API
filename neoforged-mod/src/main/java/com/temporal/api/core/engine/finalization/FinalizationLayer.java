package com.temporal.api.core.engine.finalization;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.finalization.cleaner.ObjectPoolCleaner;

import java.util.List;

public class FinalizationLayer implements EngineLayer {
    private List<ObjectPoolCleaner> objectPoolCleaners;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Running {} ObjectPoolCleaners", objectPoolCleaners.size());
        objectPoolCleaners.forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.debug("Running dynamic ObjectPoolCleaners from pool");
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.getObjects(ObjectPoolCleaner.class)
                .forEach(ObjectPoolCleaner::clear);
    }

    public void setContextCleaners(List<ObjectPoolCleaner> objectPoolCleaners) {
        this.objectPoolCleaners = objectPoolCleaners;
    }
}
