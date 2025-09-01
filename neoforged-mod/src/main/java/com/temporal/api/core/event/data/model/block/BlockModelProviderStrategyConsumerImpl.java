package com.temporal.api.core.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static com.temporal.api.core.event.data.model.block.BlockModelDescriptionContainer.*;

public class BlockModelProviderStrategyConsumerImpl implements BlockModelProviderStrategyConsumer {
    @Override
    public void registerModels(@NotNull ApiBlockModelProvider provider, String... additionalData) {
        CUBED_BLOCKS.forEach(registerBlockModel(provider, CubedBlockModelProviderStrategy::new));
        CUTOUT_CUBED_BLOCKS.forEach(registerBlockModel(provider, CutoutCubedBlockModelProviderStrategy::new));
        CROSS_BLOCKS.forEach(registerBlockModel(provider, CrossBlockModelProviderStrategy::new));
        FLOWER_BLOCKS.forEach(registerBlockModel(provider, FlowerBlockModelProviderStrategy::new));
        LOGS.forEach(registerBlockModel(provider, LogBlockModelProviderStrategy::new));
        WOODS.forEach(registerBlockModel(provider, WoodBlockModelProviderStrategy::new));
        BUTTONS.forEach(registerBlockModel(provider, ButtonBlockModelProviderStrategy::new));
        DOORS.forEach(registerBlockModel(provider, DoorBlockModelProviderStrategy::new));
        FENCES.forEach(registerBlockModel(provider, FenceBlockModelProviderStrategy::new));
        FENCE_GATES.forEach(registerBlockModel(provider, FenceGateBlockModelProviderStrategy::new));
        PRESSURE_PLATES.forEach(registerBlockModel(provider, PressurePlateBlockModelProviderStrategy::new));
        SLABS.forEach(registerBlockModel(provider, SlabBlockModelProviderStrategy::new));
        STAIRS.forEach(registerBlockModel(provider, StairsBlockModelProviderStrategy::new));
        TRAPDOORS.forEach(registerBlockModel(provider, TrapDoorBlockModelProviderStrategy::new));
        WALLS.forEach(registerBlockModel(provider, WallBlockModelProviderStrategy::new));
        SIGNS.forEach(registerBlockModel(provider, SignBlockModelProviderStrategy::new));
        HANGING_SIGNS.forEach(registerBlockModel(provider, HangingSignBlockModelProviderStrategy::new));
        BARRELS.forEach(registerBlockModel(provider, BarrelBlockModelProviderStrategy::new));
        VINES.forEach(registerBlockModel(provider, VineBlockModelProviderStrategy::new));
        CARPETS.forEach(registerBlockModel(provider, CarpetBlockModelProviderStrategy::new));
        PANES.forEach(registerBlockModel(provider, PaneBlockModelProviderStrategy::new));
        RAILS.forEach(registerBlockModel(provider, RailBlockModelProviderStrategy::new));
        CUSTOM_MODELS.forEach((key, value) -> value.registerBlockModel(key.getA(), provider, key.getB()));
    }

    @Override
    public BiConsumer<Holder<? extends Block>, String[]> registerBlockModel(@NotNull ApiBlockModelProvider provider, @NotNull Supplier<BlockModelProviderStrategy> blockModelProviderStrategy) {
        return (block, additionalData) -> blockModelProviderStrategy.get().registerBlockModel(block, provider, additionalData);
    }
}
