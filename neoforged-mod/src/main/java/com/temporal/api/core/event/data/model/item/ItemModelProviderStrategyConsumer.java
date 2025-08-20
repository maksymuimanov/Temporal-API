package com.temporal.api.core.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface ItemModelProviderStrategyConsumer {
    void registerModels(@NotNull ApiItemModelProvider provider, String... additionalData);

    BiConsumer<Holder<? extends Item>, String[]> registerItemModel(@NotNull ApiItemModelProvider provider, @NotNull Supplier<ItemModelProviderStrategy> itemModelProviderStrategy);
}
