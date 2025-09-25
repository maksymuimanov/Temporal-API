# Temporal API - NeoForge Mod Framework (neoforged-mod)

Stop hand-writing JSON and plumbing registries. Ship content faster with an annotation-first workflow for NeoForge.

- Module documented here: neoforged-mod
- Advanced examples: neoforged-example

---

## Navigation

- [TL;DR](#tldr)
- [Installation](#installation)
- [Overview](#overview)
- [Core concepts](#core-concepts)
- [Structure](#structure)
- [Annotations (catalog)](#annotations-catalog)
- [Basic examples](#basic-examples)
  - [A) Bootstrapping TemporalEngine](#a-bootstrapping-temporalengine)
  - [B) Registering an Item](#b-registering-an-item)
- [Running Data Generation](#running-data-generation)
- [Best Practices](#best-practices)
- [Troubleshooting](#troubleshooting)
- [Learn more](#learn-more)

---

## TL;DR

- ⚡ Add one line in your @Mod constructor: `TemporalEngine.run(...)`.
- 🧱 Declare Blocks/Items with concise factories; annotate to auto-generate models, loot, recipes, tags, lang, worldgen.
- 🏷️ Rich Tag helpers for blocks, items, biomes, entities, instruments, structures, and more.
- 🧩 Extensible: create your own annotations by writing a small Strategy; plug into existing Processors.
- 🧰 Works with standard NeoForge runData. JSON lands in `src/generated/resources`.

---

## Installation

For working with our library, you need to go to `build.gradle` and add this:

```groovy
repositories {
  maven {
    url "https://cursemaven.com"
  }
}

dependencies {
  //...
  implementation "curse.maven:temporalapi-970291:<file-id>"
}
```

You need to replace <file-id> with the file id that can be found at the end of the link of the needed version of the mod file.

Also, you should check out some examples from the [Examples](https://github.com/maksymuimanov/Temporal-API/tree/master/neoforged-example)

---

## Overview

Temporal API removes Minecraft modding boilerplate for NeoForge.
- Less boilerplate: annotate content to generate JSON (models, loot, tags, recipes, languages, worldgen).
- Consistent structure: unified factories, registries, and lifecycle layers.
- Safe defaults: cube-all models, self-drop loot, sensible Block properties, etc.
- Extensible: add your own annotations via Strategy/Processor architecture.

Scope notes
- This automates registrations and data generation; it doesn’t create textures/art for you.
- Fully compatible with NeoForge data gen workflow (runData) and DeferredRegister patterns.

---

## Core concepts

TemporalEngine (entrypoint)
- Call `TemporalEngine.run(MyMod.class, eventBus, modContainer)` in your @Mod constructor to boot the framework.
- Or use the builder: TemporalEngine.emptyBuilder() → configureXxxLayer() → and() → build().
- The defaultBuilder wires all layers in a sensible order; you can disable or customize layers with EngineBuilder methods.

Builder and layers
- EngineBuilder exposes configureInitializationLayer, configureRegistryLayer, configureMetadataLayer, configureConfigLayer, configureEventLayer, configureFinalizationLayer. Each returns a layer builder; call and() to apply and continue chaining.
- EngineBuilder.processLayer(...) runs a layer immediately; build() just returns the container after registration.

Layers (what they represent)
- InitializationLayer: discovers classes, builds the per‑mod ObjectPool, seeds it with external sources (event bus, mod container), and prepares strategy/initializer infrastructure.
- RegistryLayer: registers your DeferredRegister-backed factories against NeoForge’s IEventBus (dynamic scanning, no boilerplate).
- MetadataLayer: scans annotations on classes/fields/methods and enqueues work into processors (e.g., data providers, event wiring).
- ConfigLayer: processes configuration-related annotations.
- EventLayer: processes event-time annotations (creative tabs, setup hooks, render hints, etc.).
- FinalizationLayer: final wrap-up after metadata/event processing.

InjectionPool (per‑mod DI)
- Lightweight injector bound to the current mod. Retrieve components via InjectionPool.getFromInstance(SomeType.class) or InjectionPool.getInstance().get(SomeType.class).
- Used to expose shared utilities (e.g., factories, processor pools, directors) and external sources (IEventBus, ModContainer) to strategies/processors.

ModContext (mod identity and pools)
- Holds the current NeoMod (modId + discovered class set) in ModContext.NEO_MOD and a map of per‑mod Injection/Object pools.
- API: createPool(modId), getPool(modId), removePool(modId). Layers use this to scope work to the active mod.

Factories and FactoryRegistrar
- ObjectFactory<T> implementations encapsulate DeferredRegister and builders for content (Blocks, Items, Entities, etc.).
- FactoryRegistrar registers all factories to the IEventBus. Default is FieldTypeFactoryRegistrar which:
  - Scans your discovered classes for static fields of type ObjectFactory<?>.
  - Fetches each factory from InjectionPool and calls factory.register(eventBus, declaringClass).
- An alternative AnnotatedFactoryRegistrar exists to opt-in with @RegisterFactory on factory fields.

Annotations (package, strategy, processor)
- Packages: com.temporal.api.core.engine.metadata.annotation.* contain user-facing annotations (models, loot, tags, recipes, lang, worldgen, events, properties).
- Strategies: com.temporal.api.core.engine.metadata.strategy.* implement Field/Class/MethodAnnotationStrategy and are discovered via @Strategy to declare processor scope.
- Processors: com.temporal.api.core.engine.metadata.processor.* collect strategy subscriptions (via a ProcessorPool such as SimpleProcessorPool) and execute them, optionally with different consumers (simple/async).

---

## Structure

Mod flow with Temporal API

1) Entrypoint
- In your @Mod constructor call TemporalEngine.run(MyMod.class, eventBus, modContainer). This prints a banner, logs the mod name, and builds the default layer pipeline.
- Equivalent builder form:
```java
TemporalEngine.emptyBuilder()
    .configureInitializationLayer().modClass(MyMod.class).externalSource(List.of(eventBus, modContainer)).and()
    .configureRegistryLayer().and()
    .configureMetadataLayer().and()
    .configureConfigLayer().and()
    .configureEventLayer().and()
    .configureFinalizationLayer().and()
    .build();
```

2) InitializationLayer - discover and prepare
- Creates NeoMod from your mod class and scanners: NeoMod.create(modClass, scanners) and assigns ModContext.NEO_MOD.
- Discovers all classes belonging to your mod and merges with API classes for bootstrapping.
- Creates a per‑mod ObjectPool via ModContext.getInstance().createPool(modId) and seeds it with external sources (IEventBus, ModContainer).
- Runs default ObjectPoolInitializer instances (e.g., strategy pools, processor pools) and then any dynamic initializers that were added during initialization.

3) RegistryLayer - register DeferredRegisters via factories
- Fetches IEventBus from InjectionPool and iterates configured FactoryRegistrar implementations.
- Default FieldTypeFactoryRegistrar scans discovered classes for static fields implementing ObjectFactory<?> and calls factory.register(eventBus, declaringClass).
- Optional AnnotatedFactoryRegistrar lets you opt-in explicitly with @RegisterFactory on factory fields.
- Result: All your factories (blocks/items/entities/etc.) bind their DeferredRegister to the mod event bus without boilerplate.

4) MetadataLayer - process annotations
- Runs AnnotationDirectors (ClassAnnotationDirector, FieldAnnotationDirector, MethodAnnotationDirector) to scan classes/fields/methods.
- Directors subscribe annotation Strategies into a ProcessorPool (SimpleProcessorPool) under named ProcessorScope(s).
- Then processorPool.processAll() executes processors; strategies run via consumers (simple/async) to:
  - Generate data (models, loot, recipes, tags, lang, worldgen) into src/generated/resources.
  - Wire events (creative tabs, FML setups, block entities, render hints, etc.).

5) ConfigLayer - configuration wiring
- Processes configuration-related annotations (if present) and registers config specs as needed.

6) EventLayer - event phase helpers
- Applies event-time annotations (e.g., tab population, FML client/common setup helpers) and any custom event consumers.

7) FinalizationLayer - wrap-up
- Performs final tasks after metadata/event work; ideal for post-processing or cleanups added by extensions.

---

## Annotations (catalog)

| Package                                                           | Names                                                     | Type    | Short description                                                                                                       |
|-------------------------------------------------------------------|-----------------------------------------------------------|---------|-------------------------------------------------------------------------------------------------------------------------|
| com.temporal.api.core.engine.metadata.annotation.data.language    | `TranslateAmericanEnglish`; `TranslateMultiple`           | `field` | Add localized strings (item/block names, advancement titles/descriptions, etc.).                                        |
| com.temporal.api.core.engine.metadata.annotation.data.model.block | `GenerateCubedBlockModel`; `GenerateLogBlockModel`        | `field` | Generate block models (cube-all, cross, flower, log/wood, slab/stairs, fence/gate, sign/hanging sign, wall/vine, etc.). |
| com.temporal.api.core.engine.metadata.annotation.data.model.item  | `GenerateBasicItemModel`; `GenerateHandheldItemModel`     | `field` | Generate item models (basic/flat/cube, handheld, bow/crossbow, spawn egg, trimmed armor, etc.).                         |
| com.temporal.api.core.engine.metadata.annotation.data.loot        | `GenerateSelfBlockLootTable`; `GenerateOreBlockLootTable` | `field` | Generate block loot (self-drop, silk touch, ore/raw, leaves with sapling chances, grass, potted, empty).                |
| com.temporal.api.core.engine.metadata.annotation.data.tag         | `AddBlockTag`; `AddItemTag`                               | `field` | Add registry entries to tags (blocks/items and more families); supports multiple values.                                |
| com.temporal.api.core.engine.metadata.annotation.data.properties  | `Compostable`; `FurnaceFuel`                              | `field` | Mark items as compostable or usable as furnace fuel with parameters.                                                    |
| com.temporal.api.core.engine.metadata.annotation.data             | `GenerateRecipe`                                          | `class` | Generate a recipe from a description class (e.g., ShapelessRecipeDescription, ShapedRecipeDescription).                 |
| com.temporal.api.core.engine.metadata.annotation.data             | `GenerateAdvancement`                                     | `class` | Generate an advancement from an AdvancementDescription implementation.                                                  |
| com.temporal.api.core.engine.metadata.annotation.data.biome       | `GenerateOre`; `GenerateTree`                             | `field` | Worldgen configured features with inline configuration and placement or biome modifier spec.                            |
| com.temporal.api.core.engine.metadata.annotation.event.creative   | `AddCreativeModeTab`                                      | `field` | Insert entries into existing creative mode tabs.                                                                        |
| com.temporal.api.core.engine.metadata.annotation.event.block      | `AddBlockEntityType`                                      | `field` | Attach a vanilla/NeoForge block entity type id to a block registration.                                                 |
| com.temporal.api.core.engine.metadata.annotation.event.fml        | `SetupBow`; `SetupCrossbow`                               | `field` | Perform standard FML setup for ranged items (bow/crossbow).                                                             |
| com.temporal.api.core.engine.metadata.annotation.injection        | `Strategy`; `Processor`; `RegisterFactory`                | `class` | Extension points: register strategies/processors or opt-in factory registration.                                        |

Note: Names show 1–2 examples per package; more annotations exist (etc.).

---

## Basic examples

### A) Bootstrapping TemporalEngine
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

### B) Registering an Item

```java
public final class MyItems {
    private static final ItemFactory ITEM_FACTORY = InjectionPool.getFromInstance(ItemFactory.class);
    
    @AddCreativeModeTab(CreativeModeTabType.INGREDIENTS) 
    @GenerateBasicItemModel 
    @TranslateAmericanEnglish("My Ingot") 
    public static final DeferredItem<?> MY_INGOT = ITEMS.create("my_ingot");
}
```

Run `runData` to produce models/lang JSON automatically and then `runClient` and you are good to go :D!.

## Running Data Generation

Use your standard NeoForge workflow (Gradle task `runData`). Temporal annotations integrate with the data providers and emit JSON into `src/generated/resources`:
- assets/<modid>/models
- assets/<modid>/lang
- data/<modid>/loot_table
- data/<modid>/tags
- data/<modid>/recipes
- data/<modid>/worldgen

Commit generated files or keep them generated-on-demand as per your project policy.

---

## Best Practices

- Keep annotated fields `public static final` for blocks/items when appropriate to avoid lazy-loading issues.
- Co-locate annotations with the declaration they describe (models/loot/lang on the field).
- Prefer provided factories; they set sensible defaults and integrate with data-gen.
- Use TranslateMultiple for bundles and companion strings (`suffix = "desc"`).
- Keep worldgen annotations next to your configured feature keys to keep ids + config together.

---

## Troubleshooting

- No JSON generated: Ensure `TemporalEngine.run(...)` is called in your @Mod constructor and run `runData`.
- Wrong textures or missing parents: Check your Generate*Model annotations and texture paths.
- Loot/Tags not applied: Verify annotation parameters (item ids, tag ids) and that annotated members are discovered by class scanning (public/static/etc.).
- Multi-mod setups: The engine creates per‑mod pools keyed by mod id; avoid cross-mod static references during bootstrap.

---

## Learn more

- Explore runnable, advanced patterns in the example module: neoforged-example
  - Engine bootstrap, blocks/items, recipes, worldgen, advancements, creative tabs, client setup

Happy modding! ✨