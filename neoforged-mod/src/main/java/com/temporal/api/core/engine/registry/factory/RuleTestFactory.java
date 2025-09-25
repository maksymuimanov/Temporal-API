package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RuleTestFactory extends AbstractObjectFactory<RuleTestType<?>> {
    public RuleTestFactory() {
        this(InjectionPool.getFromInstance("$RuleTests"));
    }

    public RuleTestFactory(TemporalRegister<RuleTestType<?>> register) {
        super(register);
    }

    public <T extends RuleTest> DeferredHolder<RuleTestType<?>, RuleTestType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
