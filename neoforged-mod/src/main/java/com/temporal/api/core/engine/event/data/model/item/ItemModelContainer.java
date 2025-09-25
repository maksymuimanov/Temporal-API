package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.model.item.spec.*;

import java.util.Map;
import java.util.Queue;

public final class ItemModelContainer {
    public static final Queue<ItemModelSpec> BASIC_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> HANDHELD_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> BOW_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> CROSSBOW_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> TRIMMED_ARMOR_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> POTION_ITEMS = new TemporalQueue<>();
    public static final Queue<ItemModelSpec> SPAWN_EGG_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> CUBED_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> FLAT_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> LOG_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> WOOD_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> BUTTON_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> FENCE_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> FENCE_GATE_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> PRESSURE_PLATE_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> SLAB_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> STAIRS_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<TrapDoorBlockItemModelSpec> TRAPDOOR_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<DependantBlockItemModelSpec> WALL_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> BARREL_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Queue<BlockItemModelSpec> CARPET_BLOCK_ITEMS = new TemporalQueue<>();
    public static final Map<CustomItemModelSpec, ItemModelProviderStrategy<CustomItemModelSpec>> CUSTOM_MODELS = new TemporalMap<>();
    public static final Map<CustomBlockItemModelSpec, ItemModelProviderStrategy<CustomBlockItemModelSpec>> CUSTOM_BLOCK_MODELS = new TemporalMap<>();

    private ItemModelContainer() {
    }
}
