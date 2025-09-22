package net.temporal.example.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.event.data.model.RenderTypes;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.loot.*;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.*;
import com.temporal.api.core.engine.metadata.annotation.data.model.item.*;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBlockTag;
import com.temporal.api.core.engine.metadata.annotation.event.block.AddBlockEntityType;
import com.temporal.api.core.engine.metadata.annotation.event.creative.AddCreativeModeTab;
import com.temporal.api.core.engine.metadata.constant.CreativeModeTabType;
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
    @GenerateCubedBlockModel
    @GenerateCubedBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Block")
    public static final DeferredBlock<?> EXAMPLE_BLOCK = BLOCK_FACTORY.create("example_block", BlockPropertiesFactory.empty());

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateCubedBlockModel
    @GenerateCubedBlockItemModel
    @AddBlockTag({"minecraft:mineable/pickaxe", "minecraft:needs_diamond_tool"})
    @GenerateOreBlockLootTable(rawOre = "example:example_ingot")
    @TranslateAmericanEnglish("Example Ore")
    public static final DeferredBlock<?> EXAMPLE_ORE = BLOCK_FACTORY.create("example_ore", BlockPropertiesFactory.stone());

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateCrossBlockModel
    @GenerateFlatBlockItemModel
    @GenerateGrassBlockLootTable(seeds = "minecraft:seeds")
    @TranslateAmericanEnglish("Example Grass")
    public static final DeferredBlock<?> EXAMPLE_GRASS = BLOCK_FACTORY.createFlower("example_grass", BlockPropertiesFactory.shortGrass(), MobEffects.DAMAGE_RESISTANCE, 1);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateFlowerBlockModel(pottedFlower = "example:potted_example_flower")
    @GenerateFlatBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Flower")
    public static final DeferredBlock<?> EXAMPLE_FLOWER = BLOCK_FACTORY.createFlower("example_flower", MobEffects.DAMAGE_RESISTANCE, 1);

    @GeneratePottedContentBlockLootTable
    @TranslateAmericanEnglish("Potted Example Flower")
    public static final DeferredBlock<?> POTTED_EXAMPLE_FLOWER = BLOCK_FACTORY.createPottedFlower("potted_example_flower", EXAMPLE_FLOWER);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateCubedBlockModel(renderType = RenderTypes.CUTOUT)
    @GenerateCubedBlockItemModel
    @GenerateLeavesBlockLootTable(sapling = "example:example_sapling", chances = {0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F})
    @TranslateAmericanEnglish("Example Leaves")
    public static final DeferredBlock<?> EXAMPLE_LEAVES = BLOCK_FACTORY.createLeaves("example_leaves");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateLogBlockModel
    @GenerateLogBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Stripped Log")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_LOG = BLOCK_FACTORY.createLog("example_stripped_log");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateLogBlockModel
    @GenerateLogBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Log")
    public static final DeferredBlock<?> EXAMPLE_LOG = BLOCK_FACTORY.createLog("example_log", EXAMPLE_STRIPPED_LOG);

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateWoodBlockModel
    @GenerateWoodBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Stripped Wood")
    public static final DeferredBlock<?> EXAMPLE_STRIPPED_WOOD = BLOCK_FACTORY.createLog("example_stripped_wood");

    @AddCreativeModeTab(CreativeModeTabType.NATURAL_BLOCKS)
    @GenerateWoodBlockModel
    @GenerateWoodBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Wood")
    public static final DeferredBlock<?> EXAMPLE_WOOD = BLOCK_FACTORY.createLog("example_wood", EXAMPLE_STRIPPED_WOOD);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateCrossBlockModel
    @GenerateFlatBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Sapling")
    public static final DeferredBlock<?> EXAMPLE_SAPLING = BLOCK_FACTORY.createSapling("example_sapling", ExampleConfiguredFeatures.EXAMPLE_TREE_FEATURE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateCubedBlockModel
    @GenerateCubedBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Planks")
    public static final DeferredBlock<?> EXAMPLE_PLANKS = BLOCK_FACTORY.create("example_planks", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateSlabBlockModel(fullBlock = "example:example_planks")
    @GenerateSlabBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Slab")
    public static final DeferredBlock<?> EXAMPLE_SLAB = BLOCK_FACTORY.createSlab("example_planks_slab", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateStairsBlockModel(fullBlock = "example:example_planks")
    @GenerateStairsBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Stairs")
    public static final DeferredBlock<?> EXAMPLE_STAIRS = BLOCK_FACTORY.createStair("example_planks_stairs", BlockPropertiesFactory.planks());

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateButtonBlockModel(fullBlock = "example:example_planks")
    @GenerateButtonBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Button")
    public static final DeferredBlock<?> EXAMPLE_BUTTON = BLOCK_FACTORY.createButton("example_planks_button", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GeneratePressurePlateBlockModel(fullBlock = "example:example_planks")
    @GeneratePressurePlateBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Pressure Plate")
    public static final DeferredBlock<?> EXAMPLE_PRESSURE_PLATE = BLOCK_FACTORY.createPressurePlate("example_planks_pressure_plate", ExampleBlockSetTypes.EXAMPLE_BLOCK_SET_TYPE);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @AddBlockTag("minecraft:fences")
    @GenerateFenceBlockModel(fullBlock = "example:example_planks")
    @GenerateFenceBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Fence")
    public static final DeferredBlock<?> EXAMPLE_FENCE = BLOCK_FACTORY.createFence("example_planks_fence");

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @AddBlockTag("minecraft:fence_gates")
    @GenerateFenceGateBlockModel(fullBlock = "example:example_planks")
    @GenerateFenceGateBlockItemModel(fullBlock = "example:example_planks")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Fence Gate")
    public static final DeferredBlock<?> EXAMPLE_FENCE_GATE = BLOCK_FACTORY.createFenceGate("example_planks_fence_gate", ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:signs")
    @GenerateSignBlockModel(wallSign = "example:example_wall_sign", particleTexture = "example:block/example_stripped_log")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Sign")
    @AddBlockEntityType("minecraft:sign")
    public static final DeferredBlock<StandingSignBlock> EXAMPLE_SIGN = BLOCK_FACTORY.createStandingSignWithoutItem("example_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:signs")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Sign")
    @AddBlockEntityType("minecraft:sign")
    public static final DeferredBlock<WallSignBlock> EXAMPLE_WALL_SIGN = BLOCK_FACTORY.createWallSignWithoutItem("example_wall_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:ceiling_hanging_signs")
    @GenerateHangingSignBlockModel(wallHangingSign = "example:example_wall_hanging_sign", particleTexture = "example:block/example_stripped_log")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Hanging Sign")
    @AddBlockEntityType("minecraft:hanging_sign")
    public static final DeferredBlock<CeilingHangingSignBlock> EXAMPLE_HANGING_SIGN = BLOCK_FACTORY.createCeilingHangingSignWithoutItem("example_hanging_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);

    @AddBlockTag("minecraft:wall_hanging_signs")
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("Example Hanging Sign")
    @AddBlockEntityType("minecraft:hanging_sign")
    public static final DeferredBlock<WallHangingSignBlock> EXAMPLE_HANGING_WALL_SIGN = BLOCK_FACTORY.createWallHangingSignWithoutItem("example_wall_hanging_sign", 1f, ExampleWoodTypes.EXAMPLE_WOOD_TYPE);
}
