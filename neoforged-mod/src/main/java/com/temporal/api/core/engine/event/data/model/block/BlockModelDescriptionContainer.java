package com.temporal.api.core.engine.event.data.model.block;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.model.block.spec.*;
import com.temporal.api.core.engine.event.data.model.block.strategy.BlockModelProviderStrategy;

import java.util.Map;
import java.util.Queue;

public final class BlockModelDescriptionContainer {
    public static final Queue<BlockModelSpec> CUBED_BLOCKS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> CROSS_BLOCKS = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> FLOWER_BLOCKS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> LOGS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> WOODS = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> BUTTONS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> DOORS = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> FENCES = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> FENCE_GATES = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> PRESSURE_PLATES = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> SLABS = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> STAIRS = new TemporalQueue<>();
    public static final Queue<TrapDoorBlockModelSpec> TRAPDOORS = new TemporalQueue<>();
    public static final Queue<DependantBlockModelSpec> WALLS = new TemporalQueue<>();
    public static final Queue<SignBlockModelSpec> SIGNS = new TemporalQueue<>();
    public static final Queue<SignBlockModelSpec> HANGING_SIGNS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> BARRELS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> VINES = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> CARPETS = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> PANES = new TemporalQueue<>();
    public static final Queue<BlockModelSpec> RAILS = new TemporalQueue<>();
    public static final Map<CustomBlockModelSpec, BlockModelProviderStrategy<CustomBlockModelSpec>> CUSTOM_MODELS = new TemporalMap<>();

    private BlockModelDescriptionContainer() {
    }
}
