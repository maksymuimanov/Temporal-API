package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.collection.Pair;
import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BlockLootTableProvider extends ApiBlockLootTableProvider {
    public static final Map<Holder<? extends Block>, String[]> SELF = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> SILK_TOUCH = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> POTTED_CONTENTS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> ORES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> MULTIPLE_ORES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> GRASSES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> LEAVES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> SHULKER_BOXES = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> BANNERS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> MUSHROOM_BLOCKS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> SHEARS_ONLY = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> CROPS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> DOORS = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> OTHER = new TemporalMap<>();
    public static final Map<Holder<? extends Block>, String[]> EMPTY = new TemporalMap<>();
    public static final Map<Pair<Holder<? extends Block>, String[]>, LootProviderStrategy> CUSTOM_LOOT = new TemporalMap<>();

    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected void generate() {
        SELF.forEach(generateLootTable(this, SelfLootProviderStrategy::new));
        SILK_TOUCH.forEach(generateLootTable(this, SilkTouchLootProviderStrategy::new));
        POTTED_CONTENTS.forEach(generateLootTable(this, PottedContentLootProviderStrategy::new));
        ORES.forEach(generateLootTable(this, OreLootProviderStrategy::new));
        MULTIPLE_ORES.forEach(generateLootTable(this, MultipleOreLootProviderStrategy::new));
        GRASSES.forEach(generateLootTable(this, GrassLootProviderStrategy::new));
        LEAVES.forEach(generateLootTable(this, LeavesLootProviderStrategy::new));
        SHULKER_BOXES.forEach(generateLootTable(this, ShulkerBoxLootProviderStrategy::new));
        BANNERS.forEach(generateLootTable(this, BannerLootProviderStrategy::new));
        MUSHROOM_BLOCKS.forEach(generateLootTable(this, MushroomBlockLootProviderStrategy::new));
        SHEARS_ONLY.forEach(generateLootTable(this, ShearsOnlyLootProviderStrategy::new));
        CROPS.forEach(generateLootTable(this, CropLootProviderStrategy::new));
        DOORS.forEach(generateLootTable(this, DoorLootProviderStrategy::new));
        OTHER.forEach(generateLootTable(this, OtherLootProviderStrategy::new));
        EMPTY.forEach(generateLootTable(this, EmptyLootProviderStrategy::new));
        CUSTOM_LOOT.forEach((key, strategy) -> strategy.generateLoot(key.getLeft(), this, key.getRight()));
    }

    @Override
    protected BiConsumer<Holder<? extends Block>, String[]> generateLootTable(@NotNull ApiBlockLootTableProvider provider, @NotNull Supplier<LootProviderStrategy> lootProviderStrategySupplier) {
        return (blockRegistry, additionalData) -> lootProviderStrategySupplier.get().generateLoot(blockRegistry, provider, additionalData);
    }
}
