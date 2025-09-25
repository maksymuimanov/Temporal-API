package com.temporal.api.core.engine.event.data.loot;

import com.temporal.api.core.engine.event.data.loot.spec.BlockLootTableSpec;
import com.temporal.api.core.engine.event.data.loot.strategy.*;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.temporal.api.core.engine.event.data.loot.BlockLootTableContainer.*;

public class BlockLootTableProvider extends ApiBlockLootTableProvider {
    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected void generate() {
        SELF.forEach(this.generateLootTable(this, SelfLootProviderStrategy::new));
        SILK_TOUCH.forEach(this.generateLootTable(this, SilkTouchLootProviderStrategy::new));
        POTTED_CONTENTS.forEach(this.generateLootTable(this, PottedContentLootProviderStrategy::new));
        ORES.forEach(this.generateLootTable(this, OreLootProviderStrategy::new));
        MULTIPLE_ORES.forEach(this.generateLootTable(this, MultipleOreLootProviderStrategy::new));
        GRASSES.forEach(this.generateLootTable(this, GrassLootProviderStrategy::new));
        LEAVES.forEach(this.generateLootTable(this, LeavesLootProviderStrategy::new));
        SHULKER_BOXES.forEach(this.generateLootTable(this, ShulkerBoxLootProviderStrategy::new));
        BANNERS.forEach(this.generateLootTable(this, BannerLootProviderStrategy::new));
        MUSHROOM_BLOCKS.forEach(this.generateLootTable(this, MushroomBlockLootProviderStrategy::new));
        SHEARS_ONLY.forEach(this.generateLootTable(this, ShearsOnlyLootProviderStrategy::new));
        CROPS.forEach(this.generateLootTable(this, CropLootProviderStrategy::new));
        DOORS.forEach(this.generateLootTable(this, DoorLootProviderStrategy::new));
        OTHER.forEach(this.generateLootTable(this, OtherLootProviderStrategy::new));
        EMPTY.forEach(this.generateLootTable(this, EmptyLootProviderStrategy::new));
        CUSTOM_LOOT.forEach((spec, strategy) -> strategy.generateLoot(spec, this));
    }

    @Override
    protected <T extends BlockLootTableSpec> Consumer<T> generateLootTable(@NotNull ApiBlockLootTableProvider provider, @NotNull Supplier<LootProviderStrategy<T>> lootProviderStrategySupplier) {
        return spec -> lootProviderStrategySupplier.get().generateLoot(spec, provider);
    }
}
