package com.temporal.api.core.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static com.temporal.api.core.event.data.model.item.ItemModelDescriptionContainer.*;

public class ItemModelProviderStrategyConsumerImpl implements ItemModelProviderStrategyConsumer {
    @Override
    public void registerModels(@NotNull ApiItemModelProvider provider, String... additionalData) {
        BASIC_ITEMS.forEach(registerItemModel(provider, BasicItemModelProviderStrategy::new));
        HANDHELD_ITEMS.forEach(registerItemModel(provider, HandheldItemModelProviderStrategy::new));
        BOW_ITEMS.forEach(registerItemModel(provider, BowModelProviderStrategy::new));
        CROSSBOW_ITEMS.forEach(registerItemModel(provider, CrossbowModelProviderStrategy::new));
        TRIMMED_ARMOR_ITEMS.forEach(registerItemModel(provider, TrimmedItemModelProviderStrategy::new));
        POTION_ITEMS.forEach(registerItemModel(provider, PotionItemModelProviderStrategy::new));
        BLOCK_ITEMS.forEach(registerItemModel(provider, BlockItemModelProviderStrategy::new));
        CUSTOM_MODELS.forEach((key, value) -> value.registerItemModel(key.getLeft(), provider, key.getRight()));
    }

    @Override
    public BiConsumer<Holder<? extends Item>, String[]> registerItemModel(@NotNull ApiItemModelProvider provider, @NotNull Supplier<ItemModelProviderStrategy> itemModelProviderStrategy) {
        return (item, additionalData) -> itemModelProviderStrategy.get().registerItemModel(item, provider, additionalData);
    }
}
