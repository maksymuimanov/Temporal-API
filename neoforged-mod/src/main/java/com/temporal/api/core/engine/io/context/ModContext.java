package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.resource.NeoMod;
import com.temporal.api.core.exception.PoolCreationException;
import com.temporal.api.core.exception.PoolDeletionException;
import com.temporal.api.core.exception.PoolGettingException;

import java.util.HashMap;
import java.util.Map;

public class ModContext implements Context<String, InjectionPool> {
    private static volatile ModContext instance;
    private final Map<NeoMod, InjectionPool> injectionPools = new HashMap<>();

    private ModContext() {
    }

    @Override
    public InjectionPool getPool(String modId) {
        NeoMod mod = injectionPools.keySet()
                .stream()
                .filter(m -> m.getModId().equals(modId))
                .findAny()
                .orElseThrow(() -> new PoolGettingException("Could not find pool for modId: " + modId));
        return injectionPools.get(mod);
    }

    @Override
    public InjectionPool createPool(String modId) {
        if (injectionPools.keySet()
                .stream()
                .map(m -> m.getModId().equals(modId))
                .filter(b -> b)
                .findAny()
                .orElse(false)) throw new PoolCreationException("Pool already exists!");
        injectionPools.put(IOLayer.NEO_MOD, new InjectionPool());
        return getPool(modId);
    }

    @Override
    public void removePool(String modId) {
        injectionPools.keySet()
                .stream()
                .filter(m -> m.getModId().equals(modId))
                .findAny()
                .ifPresentOrElse(injectionPools::remove, () -> {
                    throw new PoolDeletionException("Pool does not exist!");
                });
    }

    public static ModContext getInstance() {
        if (instance == null) {
            synchronized (ModContext.class) {
                if (instance == null) {
                    instance = new ModContext();
                }
            }
        }

        return instance;
    }
}
