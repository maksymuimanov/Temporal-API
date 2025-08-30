package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ApiBlockLootTableProvider extends BlockLootSubProvider {
    protected ApiBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    protected abstract BiConsumer<Holder<? extends Block>, String[]> generateLootTable(@NotNull ApiBlockLootTableProvider provider, @NotNull Supplier<LootProviderStrategy> lootProviderStrategySupplier);

    public void dropSharedSelf(DeferredBlock<?> block, Function<String, String> mapper) {
        Block mainBlock = block.value();
        String id = RegistryUtils.getIdFromRegistry(BuiltInRegistries.BLOCK, mainBlock);
        Item item = RegistryUtils.getItem(id);
        Block sharedBlock = RegistryUtils.getBlock(mapper.apply(id));
        this.dropOther(mainBlock, item);
        this.dropOther(sharedBlock, item);
    }

    @Override
    public void dropPottedContents(@NotNull Block flowerPot) {
        super.dropPottedContents(flowerPot);
    }

    @Override
    public void dropOther(@NotNull Block block, @NotNull ItemLike item) {
        super.dropOther(block, item);
    }

    @Override
    public void dropWhenSilkTouch(@NotNull Block block) {
        super.dropWhenSilkTouch(block);
    }

    @Override
    public void dropSelf(@NotNull Block block) {
        super.dropSelf(block);
    }

    @Override
    @NotNull
    public LootItemCondition.Builder hasSilkTouch() {
        return super.hasSilkTouch();
    }

    @Override
    @NotNull
    public LootItemCondition.Builder doesNotHaveSilkTouch() {
        return super.doesNotHaveSilkTouch();
    }

    public ApiBlockLootTableProvider(Set<Item> explosionResistant, FeatureFlagSet enabledFeatures, HolderLookup.Provider registries) {
        super(explosionResistant, enabledFeatures, registries);
    }

    public ApiBlockLootTableProvider(Set<Item> explosionResistant, FeatureFlagSet enabledFeatures, Map<ResourceKey<LootTable>, LootTable.Builder> map, HolderLookup.Provider registries) {
        super(explosionResistant, enabledFeatures, map, registries);
    }

    @Override
    @NotNull
    public <T extends FunctionUserBuilder<T>> T applyExplosionDecay(@NotNull ItemLike item, @NotNull FunctionUserBuilder<T> functionBuilder) {
        return super.applyExplosionDecay(item, functionBuilder);
    }

    @Override
    @NotNull
    public <T extends ConditionUserBuilder<T>> T applyExplosionCondition(@NotNull ItemLike item, @NotNull ConditionUserBuilder<T> conditionBuilder) {
        return super.applyExplosionCondition(item, conditionBuilder);
    }

    @Override
    @NotNull
    public LootTable.Builder createSilkTouchDispatchTable(@NotNull Block block, @NotNull LootPoolEntryContainer.Builder<?> builder) {
        return super.createSilkTouchDispatchTable(block, builder);
    }

    @Override
    @NotNull
    public LootTable.Builder createShearsDispatchTable(@NotNull Block block, @NotNull LootPoolEntryContainer.Builder<?> builder) {
        return super.createShearsDispatchTable(block, builder);
    }

    @Override
    @NotNull
    public LootTable.Builder createSilkTouchOrShearsDispatchTable(@NotNull Block block, @NotNull LootPoolEntryContainer.Builder<?> builder) {
        return super.createSilkTouchOrShearsDispatchTable(block, builder);
    }

    @Override
    @NotNull
    public LootTable.Builder createSingleItemTableWithSilkTouch(@NotNull Block block, @NotNull ItemLike item) {
        return super.createSingleItemTableWithSilkTouch(block, item);
    }

    @Override
    @NotNull
    public LootTable.Builder createSingleItemTable(@NotNull ItemLike item, @NotNull NumberProvider count) {
        return super.createSingleItemTable(item, count);
    }

    @Override
    @NotNull
    public LootTable.Builder createSingleItemTableWithSilkTouch(@NotNull Block block, @NotNull ItemLike item, @NotNull NumberProvider count) {
        return super.createSingleItemTableWithSilkTouch(block, item, count);
    }

    @Override
    @NotNull
    public LootTable.Builder createSilkTouchOnlyTable(@NotNull ItemLike item) {
        return super.createSilkTouchOnlyTable(item);
    }

    @Override
    @NotNull
    public LootTable.Builder createPotFlowerItemTable(@NotNull ItemLike item) {
        return super.createPotFlowerItemTable(item);
    }

    @Override
    @NotNull
    public LootTable.Builder createSlabItemTable(@NotNull Block block) {
        return super.createSlabItemTable(block);
    }

    @Override
    @NotNull
    public <T extends Comparable<T> & StringRepresentable> LootTable.Builder createSinglePropConditionTable(@NotNull Block block, @NotNull Property<T> property, @NotNull T value) {
        return super.createSinglePropConditionTable(block, property, value);
    }

    @Override
    @NotNull
    public LootTable.Builder createNameableBlockEntityTable(@NotNull Block block) {
        return super.createNameableBlockEntityTable(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createCopperOreDrops(@NotNull Block block) {
        return super.createCopperOreDrops(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createShulkerBoxDrop(@NotNull Block block) {
        return super.createShulkerBoxDrop(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createLapisOreDrops(@NotNull Block block) {
        return super.createLapisOreDrops(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createBannerDrop(@NotNull Block block) {
        return super.createBannerDrop(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createRedstoneOreDrops(@NotNull Block block) {
        return super.createRedstoneOreDrops(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createBeeNestDrop(@NotNull Block block) {
        return super.createBeeNestDrop(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createBeeHiveDrop(@NotNull Block block) {
        return super.createBeeHiveDrop(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createCaveVinesDrop(@NotNull Block block) {
        return super.createCaveVinesDrop(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createOreDrop(@NotNull Block block, @NotNull Item item) {
        return super.createOreDrop(block, item);
    }

    @Override
    @NotNull
    public LootTable.Builder createMushroomBlockDrop(@NotNull Block block, @NotNull ItemLike item) {
        return super.createMushroomBlockDrop(block, item);
    }

    @Override
    @NotNull
    public LootTable.Builder createGrassDrops(@NotNull Block block) {
        return super.createGrassDrops(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createMultifaceBlockDrops(@NotNull Block block, @NotNull LootItemCondition.Builder builder) {
        return super.createMultifaceBlockDrops(block, builder);
    }

    @Override
    @NotNull
    public LootTable.Builder createLeavesDrops(@NotNull Block leavesBlock, @NotNull Block saplingBlock, float @NotNull ... chances) {
        return super.createLeavesDrops(leavesBlock, saplingBlock, chances);
    }

    @Override
    @NotNull
    public LootTable.Builder createOakLeavesDrops(@NotNull Block oakLeavesBlock, @NotNull Block saplingBlock, float @NotNull ... chances) {
        return super.createOakLeavesDrops(oakLeavesBlock, saplingBlock, chances);
    }

    @Override
    @NotNull
    public LootTable.Builder createMangroveLeavesDrops(@NotNull Block block) {
        return super.createMangroveLeavesDrops(block);
    }

    @Override
    @NotNull
    public LootTable.Builder createCropDrops(@NotNull Block cropBlock, @NotNull Item grownCropItem, @NotNull Item seedsItem, @NotNull LootItemCondition.Builder dropGrownCropCondition) {
        return super.createCropDrops(cropBlock, grownCropItem, seedsItem, dropGrownCropCondition);
    }

    @Override
    @NotNull
    public LootTable.Builder createDoublePlantShearsDrop(@NotNull Block sheared) {
        return super.createDoublePlantShearsDrop(sheared);
    }

    @Override
    @NotNull
    public LootTable.Builder createDoublePlantWithSeedDrops(@NotNull Block block, @NotNull Block sheared) {
        return super.createDoublePlantWithSeedDrops(block, sheared);
    }

    @Override
    @NotNull
    public LootTable.Builder createCandleDrops(@NotNull Block candleBlock) {
        return super.createCandleDrops(candleBlock);
    }

    @Override
    @NotNull
    public LootTable.Builder createPetalsDrops(@NotNull Block petalBlock) {
        return super.createPetalsDrops(petalBlock);
    }

    @Override
    public void addNetherVinesDropTable(@NotNull Block vines, @NotNull Block plant) {
        super.addNetherVinesDropTable(vines, plant);
    }

    @Override
    @NotNull
    public LootTable.Builder createDoorTable(@NotNull Block doorBlock) {
        return super.createDoorTable(doorBlock);
    }

    @Override
    public void add(@NotNull Block block, @NotNull Function<Block, LootTable.Builder> factory) {
        super.add(block, factory);
    }

    @Override
    public void otherWhenSilkTouch(@NotNull Block block, @NotNull Block other) {
        super.otherWhenSilkTouch(block, other);
    }

    @Override
    public void add(@NotNull Block block, @NotNull LootTable.Builder builder) {
        super.add(block, builder);
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return InjectionPool.getFromInstance(BlockFactory.class)
                .getRegistry()
                .getEntries()
                .stream()
                .map(holder -> (Block) holder.get())
                .toList();
    }

    protected HolderLookup.Provider getRegistries() {
        return this.registries;
    }
}