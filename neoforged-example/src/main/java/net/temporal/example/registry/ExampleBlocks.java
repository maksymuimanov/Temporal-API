package net.temporal.example.registry;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateBlockLootTable;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateBlockModel;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateItemModel;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBlockTag;
import com.temporal.api.core.engine.metadata.annotation.event.AddBlockEntityType;
import com.temporal.api.core.engine.metadata.annotation.event.AddCreativeModeTab;
import com.temporal.api.core.engine.metadata.constant.BlockLootTableType;
import com.temporal.api.core.engine.metadata.constant.BlockModelType;
import com.temporal.api.core.engine.metadata.constant.CreativeModeTabType;
import com.temporal.api.core.engine.metadata.constant.ItemModelType;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.temporal.example.worldgen.ExampleConfiguredFeatures;

public final class ExampleBlocks {
    private static final ExampleBlockFactory BLOCK_FACTORY = InjectionPool.getFromInstance(ExampleBlockFactory.class);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(ItemModelType.CUBED)
    @GenerateBlockModel
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Block")
    public static final DeferredBlock<?> EXAMPLE_BLOCK = BLOCK_FACTORY.create("example_block", BlockPropertiesFactory.empty());

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.CUBED)
    @GenerateBlockModel
    @AddBlockTag({"minecraft:mineable/pickaxe", "minecraft:needs_diamond_tool"})
    @GenerateBlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_ingot")
    @TranslateAmericanEnglish("Example Ore")
    public static final DeferredBlock<?> EXAMPLE_ORE = BLOCK_FACTORY.create("example_ore", BlockPropertiesFactory.stone());

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.BLOCK_FLAT)
    @GenerateBlockModel(BlockModelType.CROSS)
    @GenerateBlockLootTable(BlockLootTableType.SILK_TOUCH)
    @TranslateAmericanEnglish("Example Grass")
    public static final DeferredBlock<?> EXAMPLE_GRASS = BLOCK_FACTORY.createFlower("example_grass", BlockPropertiesFactory.shortGrass(), MobEffects.DAMAGE_RESISTANCE, 1);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.BLOCK_FLAT)
    @GenerateBlockModel(value = BlockModelType.FLOWER, additionalData = {"example:potted_example_flower"})
    @GenerateBlockLootTable(BlockLootTableType.SILK_TOUCH)
    @TranslateAmericanEnglish("Example Flower")
    public static final DeferredBlock<?> EXAMPLE_FLOWER = BLOCK_FACTORY.createFlower("example_flower", MobEffects.DAMAGE_RESISTANCE, 1);

    @GenerateBlockLootTable(BlockLootTableType.POTTED_CONTENT)
    @TranslateAmericanEnglish("Potted Example Flower")
    public static final DeferredBlock<?> POTTED_EXAMPLE_FLOWER = BLOCK_FACTORY.createPottedFlower("potted_example_flower", EXAMPLE_FLOWER);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.CUBED)
    @GenerateBlockModel(BlockModelType.CUTOUT_CUBED)
    @GenerateBlockLootTable(BlockLootTableType.SILK_TOUCH)
    @TranslateAmericanEnglish("Example Leaves")
    public static final DeferredBlock<?> EXAMPLE_LEAVES = BLOCK_FACTORY.createLeaves("example_leaves");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.LOG)
    @GenerateBlockModel(BlockModelType.LOG)
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Stripped Log")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_LOG = BLOCK_FACTORY.createLog("example_stripped_log");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.LOG)
    @GenerateBlockModel(BlockModelType.LOG)
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Log")
    public static final DeferredBlock<?> EXAMPLE_LOG = BLOCK_FACTORY.createLog("example_log", EXAMPLE_STRIPPED_LOG);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.WOOD)
    @GenerateBlockModel(BlockModelType.WOOD)
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Stripped Wood")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_WOOD = BLOCK_FACTORY.createLog("example_stripped_wood");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateItemModel(ItemModelType.WOOD)
    @GenerateBlockModel(BlockModelType.WOOD)
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Wood")
    public static final DeferredBlock<?> EXAMPLE_WOOD = BLOCK_FACTORY.createLog("example_wood", EXAMPLE_STRIPPED_WOOD);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(ItemModelType.BLOCK_FLAT)
    @GenerateBlockModel(BlockModelType.CROSS)
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Sapling")
    public static final DeferredBlock<?> EXAMPLE_SAPLING = BLOCK_FACTORY.createSapling("example_sapling", ExampleConfiguredFeatures.EXAMPLE_TREE_FEATURE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(value = ItemModelType.CUBED)
    @GenerateBlockModel
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Planks")
    public static final DeferredBlock<?> EXAMPLE_PLANKS = BLOCK_FACTORY.create("example_planks", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(value = ItemModelType.SLAB, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.SLAB, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Slab")
    public static final DeferredBlock<?> EXAMPLE_SLAB = BLOCK_FACTORY.createSlab("example_planks_slab", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(value = ItemModelType.STAIRS, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.STAIRS, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Stairs")
    public static final DeferredBlock<?> EXAMPLE_STAIRS = BLOCK_FACTORY.createStair("example_planks_stairs", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(value = ItemModelType.BUTTON, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.BUTTON, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Button")
    public static final DeferredBlock<?> EXAMPLE_BUTTON = BLOCK_FACTORY.createButton("example_planks_button", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateItemModel(value = ItemModelType.PRESSURE_PLATE, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.PRESSURE_PLATE, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Pressure Plate")
    public static final DeferredBlock<?> EXAMPLE_PRESSURE_PLATE = BLOCK_FACTORY.createPressurePlate("example_planks_pressure_plate", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @AddBlockTag("minecraft:fences")
    @GenerateItemModel(value = ItemModelType.FENCE, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.FENCE, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Fence")
    public static final DeferredBlock<?> EXAMPLE_FENCE = BLOCK_FACTORY.createFence("example_planks_fence");

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @AddBlockTag("minecraft:fence_gates")
    @GenerateItemModel(value = ItemModelType.FENCE_GATE, additionalData = "example:example_planks")
    @GenerateBlockModel(value = BlockModelType.FENCE_GATE, additionalData = "example:example_planks")
    @GenerateBlockLootTable
    @TranslateAmericanEnglish("Example Fence Gate")
    public static final DeferredBlock<?> EXAMPLE_FENCE_GATE = BLOCK_FACTORY.createFenceGate("example_planks_fence_gate", ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:signs")
    @GenerateBlockModel(value = BlockModelType.SIGN, additionalData = {"example:example_wall_sign", "example:block/example_stripped_log"})
    @GenerateBlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_sign")
    @TranslateAmericanEnglish("Example Sign")
    @AddBlockEntityType("minecraft:sign")
    public static final DeferredBlock<StandingSignBlock> EXAMPLE_SIGN = BLOCK_FACTORY.createStandingSignWithoutItem("example_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:signs")
    @GenerateBlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_sign")
    @TranslateAmericanEnglish("Example Sign")
    @AddBlockEntityType("minecraft:sign")
    public static final DeferredBlock<WallSignBlock> EXAMPLE_WALL_SIGN = BLOCK_FACTORY.createWallSignWithoutItem("example_wall_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:hanging_signs")
    @GenerateBlockModel(value = BlockModelType.HANGING_SIGN, additionalData = {"example:example_wall_hanging_sign", "example:block/example_stripped_log"})
    @GenerateBlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_hanging_sign")
    @TranslateAmericanEnglish("Example Hanging Sign")
    @AddBlockEntityType("minecraft:hanging_sign")
    public static final DeferredBlock<CeilingHangingSignBlock> EXAMPLE_HANGING_SIGN = BLOCK_FACTORY.createCeilingHangingSignWithoutItem("example_hanging_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:hanging_signs")
    @GenerateBlockLootTable(value = BlockLootTableType.OTHER, additionalData = "example:example_hanging_sign")
    @TranslateAmericanEnglish("Example Hanging Sign")
    @AddBlockEntityType("minecraft:hanging_sign")
    public static final DeferredBlock<WallHangingSignBlock> EXAMPLE_HANGING_WALL_SIGN = BLOCK_FACTORY.createWallHangingSignWithoutItem("example_wall_hanging_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);
}
