# Temporal API — NeoForge Mod Framework (neoforged-mod)

Annotation-driven utilities for NeoForge that reduce Minecraft modding boilerplate. This module provides a compact engine (TemporalEngine) plus a rich set of annotations, factories, and helpers to automate registrations and data generation (models, loot tables, tags, recipes, languages, worldgen) and common setup tasks.

- Module documented here: neoforged-mod
- Example repository/module: neoforged-example

---

## Navigation

- [Overview](#overview)
- [Quick Start (Basic)](#quick-start-basic)
- [How it works (high level)](#how-it-works-high-level)
- [Annotation catalog](#annotation-catalog-by-category)
- [Running Data Generation](#running-data-generation)
- [Best Practices](#best-practices)
- [Troubleshooting](#troubleshooting)
- [Advanced examples](#advanced-examples)

---

## Overview

Why use this?
- Less boilerplate: Register blocks/items/entities and generate JSON (models, loot, tags, recipes, etc.) via annotations.
- Consistent structure: Unified factories, registries, and lifecycle layers.
- Safe defaults: Common patterns (e.g., cube-all block models, self-drop loot) are handled for you.
- Extensible: Strategy/Director/Processor architecture for adding new annotations/behaviors.

Notes & scope
- Focuses on automating data and registration glue; it does not create textures or artwork for you.
- Works with standard NeoForge data generation flows (runData) and DeferredRegister-style registries.

---

## Quick Start (Basic)

1) Bootstrap the engine in your @Mod entry point.

```java
@Mod(MyMod.MOD_ID)
public class MyMod {
    public static final String MOD_ID = "mymod";

    public MyMod(IEventBus modEventBus, ModContainer modContainer) {
        // Initializes all Temporal layers (init, registry, metadata/annotations, config, events, finalization)
        TemporalEngine.run(MyMod.class, modEventBus, modContainer);
    }
}
```

2) Declare a simple block with minimal annotations.

```java
public final class MyBlocks {
    private static final MyBlockFactory BLOCKS = InjectionPool.getFromInstance(MyBlockFactory.class);

    @AddCreativeModeTab(CreativeModeTabType.BUILDING_BLOCKS)
    @GenerateCubedBlockModel
    @GenerateCubedBlockItemModel
    @GenerateSelfBlockLootTable
    @TranslateAmericanEnglish("My Block")
    public static final DeferredBlock<?> MY_BLOCK = BLOCKS.create("my_block", BlockPropertiesFactory.empty());
}
```

3) Run data generation as usual (e.g., Gradle task `runData`). JSON will be written to `src/generated/resources`:
- assets/<modid>/models
- assets/<modid>/lang
- data/<modid>/loot_table
- data/<modid>/tags
- data/<modid>/recipes
- data/<modid>/worldgen

---

## How it works (high level)

TemporalEngine wires a sequence of layers:
- InitializationLayer: Scans your mod’s classes and API classes, builds an ObjectPool and ModContext.
- RegistryLayer: Registers content via unified registries and factories.
- MetadataLayer: Processes annotations (class/field/method) using Directors → Processors → Strategies.
- ConfigLayer: Handles configuration related annotations.
- EventLayer: Subscribes and dispatches to event annotation handlers (client setup, creative tabs, renderers, etc.).
- FinalizationLayer: Wrap-up routines after metadata/event processing.

Core context types:
- ModContext / NeoMod: Tracks current mod id, discovered classes, and per‑mod injection pools.
- InjectionPool: Lightweight dependency container; retrieve instances with `InjectionPool.getFromInstance(...)`.

See core entry points:
- com.temporal.api.core.engine.TemporalEngine
- com.temporal.api.core.engine.metadata.MetadataLayer
- com.temporal.api.core.engine.context.ModContext

---

## Annotation catalog (by category)

Representative annotations processed during the Metadata layer:

Language
- TranslateAmericanEnglish, TranslateMultiple
- Additional locales (e.g., TranslateAndalusian, TranslateNewZealandEnglish)

Models — Blocks
- GenerateCubedBlockModel, GenerateCrossBlockModel, GenerateFlowerBlockModel, GenerateLogBlockModel, GenerateWoodBlockModel
- GenerateSlabBlockModel, GenerateStairsBlockModel, GenerateFenceBlockModel, GenerateFenceGateBlockModel
- GenerateSignBlockModel, GenerateHangingSignBlockModel

Models — Items
- GenerateBasicItemModel, GenerateFlatBlockItemModel, GenerateCubedBlockItemModel
- GenerateHandheldItemModel, GenerateBowItemModel, GenerateCrossbowItemModel, GenerateSpawnEggItemModel
- GenerateTrimmedArmorItemModel

Loot Tables (Blocks)
- GenerateSelfBlockLootTable (self-drop)
- GenerateOreBlockLootTable (ores with raw drops)
- GenerateSilkTouchBlockLootTable, GenerateLeavesBlockLootTable (with sapling and chance arrays)
- GenerateGrassBlockLootTable, GeneratePottedContentBlockLootTable, GenerateEmptyBlockLootTable

Tags
- AddBlockTag, AddItemTag (single or multiple values)
- AddTagContainer (advanced tag grouping)

Recipes
- Use @GenerateRecipe on a class implementing a recipe description (e.g., ShapelessRecipeDescription, ShapedRecipeDescription).

Advancements
- @GenerateAdvancement on a class implementing AdvancementDescription (id, icon, type, criteria, etc.).

Worldgen (Configured Features & Biome Modifiers)
- GenerateOre, GenerateGrass, GenerateFlower, GenerateTree

Creative Tabs and Events
- AddCreativeModeTab(CreativeModeTabType.*) to insert entries into existing tabs.
- Client/renderer setup helpers and FML setup annotations (e.g., @SetupBow, @SetupCrossbow).

---

## Running Data Generation

Use your normal NeoForge workflow (e.g., Gradle task `runData`). Temporal annotations hook into the data-provider phase and emit JSON into `src/generated/resources`:
- assets/**/models
- assets/**/lang
- data/**/loot_table
- data/**/tags
- data/**/recipes
- data/**/worldgen (configured/placed features, biome modifiers)

Commit the generated resources or keep them generated-on-demand, per your project policy.

---

## Best Practices

- Keep annotated fields `public static final` for blocks/items where appropriate to avoid lazy-loading issues.
- Co-locate annotations with the declaration they describe (e.g., model/loot/lang annotations on the block or item field).
- Prefer factories supplied by this module; they set sensible defaults and integrate with data-gen annotations.
- Use TranslateMultiple for grouped locale entries and companion strings (e.g., `suffix = "desc"`).
- Place worldgen annotations near your configured feature keys to keep ids and config together.

---

## Troubleshooting

- No JSON generated: Ensure TemporalEngine.run(...) is called in your @Mod constructor and run `runData`.
- Wrong textures or missing parents: Verify your Generate*Model annotations (e.g., cube-all vs cross) and texture paths.
- Loot/Tags not applied: Check annotation parameters (item ids, tag ids) and that annotated members are discovered by class scanning (public/static/etc.).
- Multiple mods with Temporal API: The engine creates per‑mod pools keyed by mod id; avoid cross-mod static references during bootstrap.

---

## Advanced examples

For complete, runnable and advanced usage patterns, see the example repository/module:
- neoforged-example

This includes end‑to‑end demos (blocks, items, recipes, worldgen, advancements, creative tabs, client setup) implemented with Temporal annotations and factories.
