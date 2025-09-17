package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class PlacementModifierTypeFactory extends AbstractObjectFactory<PlacementModifierType<?>> {
    public PlacementModifierTypeFactory() {
        this(InjectionPool.getFromInstance("$PlacementModifierTypes"));
    }

    public PlacementModifierTypeFactory(TemporalRegister<PlacementModifierType<?>> register) {
        super(register);
    }

    public <T extends PlacementModifier> DeferredHolder<PlacementModifierType<?>, PlacementModifierType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
