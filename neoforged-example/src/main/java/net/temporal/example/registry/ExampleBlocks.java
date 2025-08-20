package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.EnglishTranslation;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.BlockModel;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.ItemModel;
import com.temporal.api.core.engine.io.metadata.annotation.data.other.BlockLootTable;
import com.temporal.api.core.engine.io.metadata.annotation.data.tag.BlockTagComponent;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Registry;
import com.temporal.api.core.engine.io.metadata.constant.BlockLootTableType;
import com.temporal.api.core.engine.io.metadata.constant.BlockModelType;
import com.temporal.api.core.engine.io.metadata.constant.ItemModelType;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.temporal.example.worldgen.ExampleConfiguredFeatures;

@Injected(false)
public final class ExampleBlocks {
    @Registry
    private static final ExampleBlockFactory BLOCK_FACTORY = InjectionPool.getFromInstance(ExampleBlockFactory.class);

    @ItemModel(ItemModelType.CUBED)
    @BlockModel
    @BlockLootTable
    @EnglishTranslation("Example Block")
    public static final DeferredBlock<?> EXAMPLE_BLOCK = BLOCK_FACTORY.create("example_block", BlockPropertiesFactory.empty());

    @ItemModel(ItemModelType.CUBED)
    @BlockModel
    @BlockTagComponent({"minecraft:mineable/pickaxe", "minecraft:needs_diamond_tool"})
    @BlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_ingot")
    @EnglishTranslation("Example Ore")
    public static final DeferredBlock<?> EXAMPLE_ORE = BLOCK_FACTORY.create("example_ore", BlockPropertiesFactory.stone());

    @ItemModel(ItemModelType.BLOCK_FLAT)
    @BlockModel(BlockModelType.CROSS)
    @BlockLootTable(BlockLootTableType.SILK_TOUCH)
    @EnglishTranslation("Example Grass")
    public static final DeferredBlock<?> EXAMPLE_GRASS = BLOCK_FACTORY.createFlower("example_grass", BlockPropertiesFactory.shortGrass(), MobEffects.DAMAGE_RESISTANCE, 1);

    @ItemModel(ItemModelType.BLOCK_FLAT)
    @BlockModel(value = BlockModelType.FLOWER, additionalData = {"example:potted_example_flower"})
    @BlockLootTable(BlockLootTableType.SILK_TOUCH)
    @EnglishTranslation("Example Flower")
    public static final DeferredBlock<?> EXAMPLE_FLOWER = BLOCK_FACTORY.createFlower("example_flower", MobEffects.DAMAGE_RESISTANCE, 1);

    @BlockLootTable(BlockLootTableType.POTTED_CONTENT)
    @EnglishTranslation("Potted Example Flower")
    public static final DeferredBlock<?> POTTED_EXAMPLE_FLOWER = BLOCK_FACTORY.createPottedFlower("potted_example_flower", EXAMPLE_FLOWER);

    @ItemModel(ItemModelType.CUBED)
    @BlockModel(BlockModelType.CUTOUT_CUBED)
    @BlockLootTable(BlockLootTableType.SILK_TOUCH)
    @EnglishTranslation("Example Leaves")
    public static final DeferredBlock<?> EXAMPLE_LEAVES = BLOCK_FACTORY.createLeaves("example_leaves");

    @ItemModel(ItemModelType.LOG)
    @BlockModel(BlockModelType.LOG)
    @BlockLootTable
    @EnglishTranslation("Example Stripped Log")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_LOG = BLOCK_FACTORY.createLog("example_stripped_log");

    @ItemModel(ItemModelType.LOG)
    @BlockModel(BlockModelType.LOG)
    @BlockLootTable
    @EnglishTranslation("Example Log")
    public static final DeferredBlock<?> EXAMPLE_LOG = BLOCK_FACTORY.createLog("example_log", EXAMPLE_STRIPPED_LOG);

    @ItemModel(ItemModelType.WOOD)
    @BlockModel(BlockModelType.WOOD)
    @BlockLootTable
    @EnglishTranslation("Example Stripped Wood")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_WOOD = BLOCK_FACTORY.createLog("example_stripped_wood");

    @ItemModel(ItemModelType.WOOD)
    @BlockModel(BlockModelType.WOOD)
    @BlockLootTable
    @EnglishTranslation("Example Wood")
    public static final DeferredBlock<?> EXAMPLE_WOOD = BLOCK_FACTORY.createLog("example_wood", EXAMPLE_STRIPPED_WOOD);

    @ItemModel(ItemModelType.BLOCK_FLAT)
    @BlockModel(BlockModelType.CROSS)
    @BlockLootTable
    @EnglishTranslation("Example Sapling")
    public static final DeferredBlock<?> EXAMPLE_SAPLING = BLOCK_FACTORY.createSapling("example_sapling", ExampleConfiguredFeatures.EXAMPLE_TREE_FEATURE);

    @ItemModel(value = ItemModelType.CUBED)
    @BlockModel
    @BlockLootTable
    @EnglishTranslation("Example Planks")
    public static final DeferredBlock<?> EXAMPLE_PLANKS = BLOCK_FACTORY.create("example_planks", BlockPropertiesFactory.planks());

    @ItemModel(value = ItemModelType.SLAB, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.SLAB, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Slab")
    public static final DeferredBlock<?> EXAMPLE_SLAB = BLOCK_FACTORY.createSlab("example_planks_slab", BlockPropertiesFactory.planks());

    @ItemModel(value = ItemModelType.STAIRS, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.STAIRS, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Stairs")
    public static final DeferredBlock<?> EXAMPLE_STAIRS = BLOCK_FACTORY.createStair("example_planks_stairs", BlockPropertiesFactory.planks());

    @ItemModel(value = ItemModelType.BUTTON, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.BUTTON, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Button")
    public static final DeferredBlock<?> EXAMPLE_BUTTON = BLOCK_FACTORY.createButton("example_planks_button");

    @ItemModel(value = ItemModelType.PRESSURE_PLATE, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.PRESSURE_PLATE, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Pressure Plate")
    public static final DeferredBlock<?> EXAMPLE_PRESSURE_PLATE = BLOCK_FACTORY.createPressurePlate("example_planks_pressure_plate");

    @BlockTagComponent("minecraft:fences")
    @ItemModel(value = ItemModelType.FENCE, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.FENCE, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Fence")
    public static final DeferredBlock<?> EXAMPLE_FENCE = BLOCK_FACTORY.createFence("example_planks_fence");

    @BlockTagComponent("minecraft:fence_gates")
    @ItemModel(value = ItemModelType.FENCE_GATE, additionalData = "example:example_planks")
    @BlockModel(value = BlockModelType.FENCE_GATE, additionalData = "example:example_planks")
    @BlockLootTable
    @EnglishTranslation("Example Fence Gate")
    public static final DeferredBlock<?> EXAMPLE_FENCE_GATE = BLOCK_FACTORY.createFenceGate("example_planks_fence_gate", WoodType.OAK);

    @BlockTagComponent("minecraft:signs")
    @ItemModel
    @BlockModel(value = BlockModelType.SIGN, additionalData = {"example:example_wall_sign", "example:block/example_stripped_log"})
    @BlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_sign")
    @EnglishTranslation("Example Sign")
    public static final DeferredBlock<StandingSignBlock> EXAMPLE_SIGN = BLOCK_FACTORY.createStandingSignWithoutItem("example_sign", 1f, WoodType.OAK);

    @BlockTagComponent("minecraft:signs")
    @BlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_sign")
    @EnglishTranslation("Example Sign")
    public static final DeferredBlock<WallSignBlock> EXAMPLE_WALL_SIGN = BLOCK_FACTORY.createWallSignWithoutItem("example_wall_sign", 1f, WoodType.OAK);

    @BlockTagComponent("minecraft:hanging_signs")
    @ItemModel
    @BlockModel(value = BlockModelType.HANGING_SIGN, additionalData = {"example:example_wall_hanging_sign", "example:block/example_stripped_log"})
    @BlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_hanging_sign")
    @EnglishTranslation("Example Hanging Sign")
    public static final DeferredBlock<CeilingHangingSignBlock> EXAMPLE_HANGING_SIGN = BLOCK_FACTORY.createCeilingHangingSignWithoutItem("example_hanging_sign", 1f, WoodType.OAK);

    @BlockTagComponent("minecraft:hanging_signs")
    @BlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_hanging_sign")
    @EnglishTranslation("Example Hanging Sign")
    public static final DeferredBlock<WallHangingSignBlock> EXAMPLE_HANGING_WALL_SIGN = BLOCK_FACTORY.createWallHangingSignWithoutItem("example_wall_hanging_sign", 1f, WoodType.OAK);
}
