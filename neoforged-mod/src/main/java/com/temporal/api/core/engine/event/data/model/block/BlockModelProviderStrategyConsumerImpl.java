package com.temporal.api.core.engine.event.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.engine.event.data.model.block.strategy.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.temporal.api.core.engine.event.data.model.block.BlockModelDescriptionContainer.*;

public class BlockModelProviderStrategyConsumerImpl implements BlockModelProviderStrategyConsumer {
    @Override
    public void registerModels(@NotNull ApiBlockModelProvider provider) {
        CUBED_BLOCKS.forEach(this.registerBlockModel(provider, CubedBlockModelProviderStrategy::new));
        CROSS_BLOCKS.forEach(this.registerBlockModel(provider, CrossBlockModelProviderStrategy::new));
        FLOWER_BLOCKS.forEach(this.registerBlockModel(provider, FlowerBlockModelProviderStrategy::new));
        LOGS.forEach(this.registerBlockModel(provider, LogBlockModelProviderStrategy::new));
        WOODS.forEach(this.registerBlockModel(provider, WoodBlockModelProviderStrategy::new));
        BUTTONS.forEach(this.registerBlockModel(provider, ButtonBlockModelProviderStrategy::new));
        DOORS.forEach(this.registerBlockModel(provider, DoorBlockModelProviderStrategy::new));
        FENCES.forEach(this.registerBlockModel(provider, FenceBlockModelProviderStrategy::new));
        FENCE_GATES.forEach(this.registerBlockModel(provider, FenceGateBlockModelProviderStrategy::new));
        PRESSURE_PLATES.forEach(this.registerBlockModel(provider, PressurePlateBlockModelProviderStrategy::new));
        SLABS.forEach(this.registerBlockModel(provider, SlabBlockModelProviderStrategy::new));
        STAIRS.forEach(this.registerBlockModel(provider, StairsBlockModelProviderStrategy::new));
        TRAPDOORS.forEach(this.registerBlockModel(provider, TrapDoorBlockModelProviderStrategy::new));
        WALLS.forEach(this.registerBlockModel(provider, WallBlockModelProviderStrategy::new));
        SIGNS.forEach(this.registerBlockModel(provider, SignBlockModelProviderStrategy::new));
        HANGING_SIGNS.forEach(this.registerBlockModel(provider, HangingSignBlockModelProviderStrategy::new));
        BARRELS.forEach(this.registerBlockModel(provider, BarrelBlockModelProviderStrategy::new));
        VINES.forEach(this.registerBlockModel(provider, VineBlockModelProviderStrategy::new));
        CARPETS.forEach(this.registerBlockModel(provider, CarpetBlockModelProviderStrategy::new));
        PANES.forEach(this.registerBlockModel(provider, PaneBlockModelProviderStrategy::new));
        RAILS.forEach(this.registerBlockModel(provider, RailBlockModelProviderStrategy::new));
        CUSTOM_MODELS.forEach((spec, strategy) -> strategy.registerBlockModel(spec, provider));
    }

    @Override
    public <T extends BlockModelSpec> Consumer<T> registerBlockModel(@NotNull ApiBlockModelProvider provider, @NotNull Supplier<BlockModelProviderStrategy<T>> blockModelProviderStrategy) {
        return spec -> blockModelProviderStrategy.get().registerBlockModel(spec, provider);
    }
}
