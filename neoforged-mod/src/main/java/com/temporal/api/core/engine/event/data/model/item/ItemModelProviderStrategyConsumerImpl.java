package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import com.temporal.api.core.engine.event.data.model.item.strategy.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.temporal.api.core.engine.event.data.model.item.ItemModelContainer.*;

public class ItemModelProviderStrategyConsumerImpl implements ItemModelProviderStrategyConsumer {
    @Override
    public void registerModels(@NotNull ApiItemModelProvider provider) {
        BASIC_ITEMS.forEach(this.registerItemModel(provider, BasicItemModelProviderStrategy::new));
        HANDHELD_ITEMS.forEach(this.registerItemModel(provider, HandheldItemModelProviderStrategy::new));
        BOW_ITEMS.forEach(this.registerItemModel(provider, BowModelProviderStrategy::new));
        CROSSBOW_ITEMS.forEach(this.registerItemModel(provider, CrossbowModelProviderStrategy::new));
        TRIMMED_ARMOR_ITEMS.forEach(this.registerItemModel(provider, TrimmedItemModelProviderStrategy::new));
        POTION_ITEMS.forEach(this.registerItemModel(provider, PotionItemModelProviderStrategy::new));
        SPAWN_EGG_ITEMS.forEach(this.registerItemModel(provider, SpawnEggItemModelProviderStrategy::new));
        CUBED_BLOCK_ITEMS.forEach(this.registerItemModel(provider, CubedBlockItemModelProviderStrategy::new));
        FLAT_BLOCK_ITEMS.forEach(this.registerItemModel(provider, FlatBlockItemModelProviderStrategy::new));
        LOG_BLOCK_ITEMS.forEach(this.registerItemModel(provider, LogBlockItemModelProviderStrategy::new));
        WOOD_BLOCK_ITEMS.forEach(this.registerItemModel(provider, WoodBlockItemModelProviderStrategy::new));
        BUTTON_BLOCK_ITEMS.forEach(this.registerItemModel(provider, ButtonBlockItemModelProviderStrategy::new));
        FENCE_BLOCK_ITEMS.forEach(this.registerItemModel(provider, FenceBlockItemModelProviderStrategy::new));
        FENCE_GATE_BLOCK_ITEMS.forEach(this.registerItemModel(provider, FenceGateBlockItemModelProviderStrategy::new));
        PRESSURE_PLATE_BLOCK_ITEMS.forEach(this.registerItemModel(provider, PressurePlateBlockItemModelProviderStrategy::new));
        SLAB_BLOCK_ITEMS.forEach(this.registerItemModel(provider, SlabBlockItemModelProviderStrategy::new));
        STAIRS_BLOCK_ITEMS.forEach(this.registerItemModel(provider, StairsBlockItemModelProviderStrategy::new));
        TRAPDOOR_BLOCK_ITEMS.forEach(this.registerItemModel(provider, TrapDoorBlockItemModelProviderStrategy::new));
        WALL_BLOCK_ITEMS.forEach(this.registerItemModel(provider, WallBlockItemModelProviderStrategy::new));
        BARREL_BLOCK_ITEMS.forEach(this.registerItemModel(provider, BarrelBlockItemModelProviderStrategy::new));
        CARPET_BLOCK_ITEMS.forEach(this.registerItemModel(provider, CarpetBlockItemModelProviderStrategy::new));
        CUSTOM_MODELS.forEach((spec, strategy) -> strategy.registerItemModel(spec, provider));
        CUSTOM_BLOCK_MODELS.forEach((spec, strategy) -> strategy.registerItemModel(spec, provider));
    }

    @Override
    public <T extends ItemModelSpec> Consumer<T> registerItemModel(@NotNull ApiItemModelProvider provider, @NotNull Supplier<ItemModelProviderStrategy<T>> itemModelProviderStrategy) {
        return spec -> itemModelProviderStrategy.get().registerItemModel(spec, provider);
    }
}
