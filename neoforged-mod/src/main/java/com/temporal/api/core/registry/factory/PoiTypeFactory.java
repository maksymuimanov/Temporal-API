package com.temporal.api.core.registry.factory;

import com.google.common.collect.ImmutableSet;
import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

public class PoiTypeFactory extends AbstractObjectFactory<PoiType> {
    public PoiTypeFactory() {
        this(InjectionPool.getFromInstance("$PoiTypes"));
    }

    public PoiTypeFactory(DeferredRegister<PoiType> poiTypes) {
        super(poiTypes);
    }

    public DeferredHolder<PoiType, PoiType> create(String name, Block block, int maxTickets, int validRange) {
        return this.create(name, ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), maxTickets, validRange);
    }

    public DeferredHolder<PoiType, PoiType> create(String name, Set<BlockState> matchingStates, int maxTickets, int validRange) {
        return this.create(name, () -> new PoiType(matchingStates, maxTickets, validRange));
    }
}
