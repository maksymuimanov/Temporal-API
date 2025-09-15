package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;

public class MapDecorationTypeFactory extends AbstractObjectFactory<MapDecorationType> {
    public MapDecorationTypeFactory() {
        this(InjectionPool.getFromInstance("$MapDecorationTypes"));
    }

    public MapDecorationTypeFactory(TemporalRegister<MapDecorationType> register) {
        super(register);
    }
}
