package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.collection.Pair;
import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.util.Map;

public final class ItemModelDescriptionContainer {
    public static final Map<Holder<? extends Item>, String[]> BASIC_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> HANDHELD_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> BOW_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> CROSSBOW_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> TRIMMED_ARMOR_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> POTION_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> CUBED_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> BLOCK_FLAT_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> LOG_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> WOOD_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> BUTTON_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> FENCE_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> FENCE_GATE_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> PRESSURE_PLATE_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> SLAB_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> STAIRS_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> TRAPDOOR_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> WALL_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> BARREL_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Holder<? extends Item>, String[]> CARPET_BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Pair<Holder<? extends Item>, String[]>, ItemModelProviderStrategy> CUSTOM_MODELS = new TemporalMap<>();

    private ItemModelDescriptionContainer() {
    }
}
