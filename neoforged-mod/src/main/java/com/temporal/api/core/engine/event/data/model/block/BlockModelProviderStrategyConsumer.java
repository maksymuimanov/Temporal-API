package com.temporal.api.core.engine.event.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.engine.event.data.model.block.strategy.BlockModelProviderStrategy;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BlockModelProviderStrategyConsumer {
    void registerModels(@NotNull ApiBlockModelProvider provider);

    <T extends BlockModelSpec> Consumer<T> registerBlockModel(@NotNull ApiBlockModelProvider provider, @NotNull Supplier<BlockModelProviderStrategy<T>> blockModelProviderStrategy);
}
