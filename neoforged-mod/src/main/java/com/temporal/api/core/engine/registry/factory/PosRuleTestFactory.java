package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosRuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosRuleTestType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class PosRuleTestFactory extends AbstractObjectFactory<PosRuleTestType<?>> {
    public PosRuleTestFactory() {
        this(InjectionPool.getFromInstance("$PosRuleTests"));
    }

    public PosRuleTestFactory(TemporalRegister<PosRuleTestType<?>> register) {
        super(register);
    }

    public <T extends PosRuleTest> DeferredHolder<PosRuleTestType<?>, PosRuleTestType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
