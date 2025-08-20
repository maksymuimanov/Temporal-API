package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.collection.Pair;
import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public final class BlockModelDescriptionContainer {
    public static final Map<Holder<? extends Block>, String[]> CUBED_BLOCKS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> CUTOUT_CUBED_BLOCKS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> CROSS_BLOCKS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> FLOWER_BLOCKS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> LOGS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> WOODS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> BUTTONS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> DOORS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> FENCES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> FENCE_GATES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> PRESSURE_PLATES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> SLABS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> STAIRS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> TRAPDOORS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> WALLS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> SIGNS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> HANGING_SIGNS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> BARRELS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> VINES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> CARPETS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> PANES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> RAILS = new TemporalMap<>();
    public static final Map<Pair<Holder<? extends Block>, String[]>, BlockModelProviderStrategy> CUSTOM_MODELS = new TemporalMap<>();

    private BlockModelDescriptionContainer() {
    }
}
