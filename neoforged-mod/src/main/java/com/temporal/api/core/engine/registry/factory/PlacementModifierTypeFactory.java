package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class PlacementModifierTypeFactory extends AbstractObjectFactory<PlacementModifierType<?>> {
    public PlacementModifierTypeFactory() {
        this(InjectionPool.getFromInstance("$PlacementModifierTypes"));
    }

    public PlacementModifierTypeFactory(TemporalRegister<PlacementModifierType<?>> register) {
        super(register);
    }
}
