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
    public static final Map<Holder<? extends Item>, String[]> BLOCK_ITEMS = new TemporalMap<>();
    public static final Map<Pair<Holder<? extends Item>, String[]>, ItemModelProviderStrategy> CUSTOM_MODELS = new TemporalMap<>();

    private ItemModelDescriptionContainer() {
    }
}
