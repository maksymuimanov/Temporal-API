package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ItemModelProviderStrategyConsumer {
    void registerModels(@NotNull ApiItemModelProvider provider);

    <T extends ItemModelSpec> Consumer<T> registerItemModel(@NotNull ApiItemModelProvider provider, @NotNull Supplier<ItemModelProviderStrategy<T>> itemModelProviderStrategy);
}
