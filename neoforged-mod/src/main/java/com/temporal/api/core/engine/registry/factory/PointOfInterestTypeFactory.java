package com.temporal.api.core.engine.registry.factory;

import com.google.common.collect.ImmutableSet;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;

public class PointOfInterestTypeFactory extends AbstractObjectFactory<PoiType> {
    public PointOfInterestTypeFactory() {
        this(InjectionPool.getFromInstance("$PointOfInterestTypes"));
    }

    public PointOfInterestTypeFactory(final TemporalRegister<PoiType> poiTypes) {
        super(poiTypes);
    }

    public DeferredHolder<PoiType, PoiType> create(final String name, final Block block, final int maxTickets, final int validRange) {
        return create(name, ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), maxTickets, validRange);
    }

    public DeferredHolder<PoiType, PoiType> create(final String name, final Set<BlockState> matchingStates, final int maxTickets, final int validRange) {
        return create(name, () -> new PoiType(matchingStates, maxTickets, validRange));
    }
}
