package com.temporal.api.core.engine.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static com.temporal.api.core.engine.event.data.model.item.ItemModelDescriptionContainer.*;

public class ItemModelProviderStrategyConsumerImpl implements ItemModelProviderStrategyConsumer {
    @Override
    public void registerModels(@NotNull ApiItemModelProvider provider, String... additionalData) {
        BASIC_ITEMS.forEach(registerItemModel(provider, BasicItemModelProviderStrategy::new));
        HANDHELD_ITEMS.forEach(registerItemModel(provider, HandheldItemModelProviderStrategy::new));
        BOW_ITEMS.forEach(registerItemModel(provider, BowModelProviderStrategy::new));
        CROSSBOW_ITEMS.forEach(registerItemModel(provider, CrossbowModelProviderStrategy::new));
        TRIMMED_ARMOR_ITEMS.forEach(registerItemModel(provider, TrimmedItemModelProviderStrategy::new));
        POTION_ITEMS.forEach(registerItemModel(provider, PotionItemModelProviderStrategy::new));
        SPAWN_EGG_ITEMS.forEach(registerItemModel(provider, SpawnEggItemModelProviderStrategy::new));
        CUBED_BLOCK_ITEMS.forEach(registerItemModel(provider, CubedBlockItemModelProviderStrategy::new));
        BLOCK_FLAT_BLOCK_ITEMS.forEach(registerItemModel(provider, BlockFlatBlockItemModelProviderStrategy::new));
        LOG_BLOCK_ITEMS.forEach(registerItemModel(provider, LogBlockItemModelProviderStrategy::new));
        WOOD_BLOCK_ITEMS.forEach(registerItemModel(provider, WoodBlockItemModelProviderStrategy::new));
        BUTTON_BLOCK_ITEMS.forEach(registerItemModel(provider, ButtonBlockItemModelProviderStrategy::new));
        FENCE_BLOCK_ITEMS.forEach(registerItemModel(provider, FenceBlockItemModelProviderStrategy::new));
        FENCE_GATE_BLOCK_ITEMS.forEach(registerItemModel(provider, FenceGateBlockItemModelProviderStrategy::new));
        PRESSURE_PLATE_BLOCK_ITEMS.forEach(registerItemModel(provider, PressurePlateBlockItemModelProviderStrategy::new));
        SLAB_BLOCK_ITEMS.forEach(registerItemModel(provider, SlabBlockItemModelProviderStrategy::new));
        STAIRS_BLOCK_ITEMS.forEach(registerItemModel(provider, StairsBlockItemModelProviderStrategy::new));
        TRAPDOOR_BLOCK_ITEMS.forEach(registerItemModel(provider, TrapdoorBlockItemModelProviderStrategy::new));
        WALL_BLOCK_ITEMS.forEach(registerItemModel(provider, WallBlockItemModelProviderStrategy::new));
        BARREL_BLOCK_ITEMS.forEach(registerItemModel(provider, BarrelBlockItemModelProviderStrategy::new));
        CARPET_BLOCK_ITEMS.forEach(registerItemModel(provider, CarpetBlockItemModelProviderStrategy::new));
        CUSTOM_MODELS.forEach((key, value) -> value.registerItemModel(key.getA(), provider, key.getB()));
    }

    @Override
    public BiConsumer<Holder<? extends Item>, String[]> registerItemModel(@NotNull ApiItemModelProvider provider, @NotNull Supplier<ItemModelProviderStrategy> itemModelProviderStrategy) {
        return (item, additionalData) -> itemModelProviderStrategy.get().registerItemModel(item, provider, additionalData);
    }
}
