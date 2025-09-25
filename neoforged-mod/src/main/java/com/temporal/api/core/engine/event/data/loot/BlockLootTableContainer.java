package com.temporal.api.core.engine.event.data.loot;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.loot.spec.*;

import java.util.Map;
import java.util.Queue;

public final class BlockLootTableContainer {
    public static final Queue<BlockLootTableSpec> SELF = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> SILK_TOUCH = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> POTTED_CONTENTS = new TemporalQueue<>();
    public static final Queue<OtherItemBlockLootTableSpec> ORES = new TemporalQueue<>();
    public static final Queue<MultipleOreBlockLootTableSpec> MULTIPLE_ORES = new TemporalQueue<>();
    public static final Queue<OtherItemBlockLootTableSpec> GRASSES = new TemporalQueue<>();
    public static final Queue<LeavesBlockLootTableSpec> LEAVES = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> SHULKER_BOXES = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> BANNERS = new TemporalQueue<>();
    public static final Queue<OtherItemBlockLootTableSpec> MUSHROOM_BLOCKS = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> SHEARS_ONLY = new TemporalQueue<>();
    public static final Queue<CropBlockLootTableSpec> CROPS = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> DOORS = new TemporalQueue<>();
    public static final Queue<OtherItemBlockLootTableSpec> OTHER = new TemporalQueue<>();
    public static final Queue<BlockLootTableSpec> EMPTY = new TemporalQueue<>();
    public static final Map<CustomBlockLootTableSpec, LootProviderStrategy<CustomBlockLootTableSpec>> CUSTOM_LOOT = new TemporalMap<>();

    private BlockLootTableContainer() {
    }
}
