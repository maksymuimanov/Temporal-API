package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;
import java.util.List;

public class TemporalRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(final Collection<Class<?>> classes, final List<?> externalObjects, final ObjectPool objectPool) {
        putRegister(objectPool, "$Activities", Registries.ACTIVITY);
        putRegister(objectPool, "$ArmorMaterials", Registries.ARMOR_MATERIAL);
        putRegister(objectPool, "$AttachmentTypes", NeoForgeRegistries.Keys.ATTACHMENT_TYPES);
        putRegister(objectPool, "$Attributes", Registries.ATTRIBUTE);
        putRegister(objectPool, "$BiomeModifierSerializers", NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS);
        putRegister(objectPool, "$BiomeSources", Registries.BIOME_SOURCE);
        putRegister(objectPool, "$BlockEntityTypes", Registries.BLOCK_ENTITY_TYPE);
        putRegister(objectPool, "$BlockPredicateTypes", Registries.BLOCK_PREDICATE_TYPE);
        putRegister(objectPool, "$BlockstateProviderTypes", Registries.BLOCK_STATE_PROVIDER_TYPE);
        putRegister(objectPool, "$Blocks", Registries.BLOCK);
        putRegister(objectPool, "$BlockTypes", Registries.BLOCK_TYPE);
        putRegister(objectPool, "$Carvers", Registries.CARVER);
        putRegister(objectPool, "$CatVariants", Registries.CAT_VARIANT);
        putRegister(objectPool, "$ChunkGenerators", Registries.CHUNK_GENERATOR);
        putRegister(objectPool, "$ChunkStatuses", Registries.CHUNK_STATUS);
        putRegister(objectPool, "$CommandArgumentTypes", Registries.COMMAND_ARGUMENT_TYPE);
        putRegister(objectPool, "$ConditionCodecs", NeoForgeRegistries.Keys.CONDITION_CODECS);
        putRegister(objectPool, "$CreativeModeTabs", Registries.CREATIVE_MODE_TAB);
        putRegister(objectPool, "$CustomStats", Registries.CUSTOM_STAT);
        putRegister(objectPool, "$DataComponentTypes", Registries.DATA_COMPONENT_TYPE);
        putRegister(objectPool, "$DecoratedPotPatterns", Registries.DECORATED_POT_PATTERN);
        putRegister(objectPool, "$DensityFunctionTypes", Registries.DENSITY_FUNCTION_TYPE);
        putRegister(objectPool, "$EnchantmentEffectComponentTypes", Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
        putRegister(objectPool, "$EnchantmentEntityEffectTypes", Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE);
        putRegister(objectPool, "$EnchantmentLocationBasedEffectTypes", Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE);
        putRegister(objectPool, "$EnchantmentProviderTypes", Registries.ENCHANTMENT_PROVIDER_TYPE);
        putRegister(objectPool, "$EnchantmentValueEffectTypes", Registries.ENCHANTMENT_VALUE_EFFECT_TYPE);
        putRegister(objectPool, "$EntityDataSerializers", NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS);
        putRegister(objectPool, "$EntitySubPredicateTypes", Registries.ENTITY_SUB_PREDICATE_TYPE);
        putRegister(objectPool, "$EntityTypes", Registries.ENTITY_TYPE);
        putRegister(objectPool, "$FeatureSizeTypes", Registries.FEATURE_SIZE_TYPE);
        putRegister(objectPool, "$Features", Registries.FEATURE);
        putRegister(objectPool, "$FloatProviderTypes", Registries.FLOAT_PROVIDER_TYPE);
        putRegister(objectPool, "$FluidIngredientTypes", NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES);
        putRegister(objectPool, "$Fluids", Registries.FLUID);
        putRegister(objectPool, "$FluidTypes", NeoForgeRegistries.Keys.FLUID_TYPES);
        putRegister(objectPool, "$FoliagePlacerTypes", Registries.FOLIAGE_PLACER_TYPE);
        putRegister(objectPool, "$FrogVariants", Registries.FROG_VARIANT);
        putRegister(objectPool, "$GameEvents", Registries.GAME_EVENT);
        putRegister(objectPool, "$GlobalLootModifierSerializers", NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS);
        putRegister(objectPool, "$HeightProviderTypes", Registries.HEIGHT_PROVIDER_TYPE);
        putRegister(objectPool, "$HolderSetTypes", NeoForgeRegistries.Keys.HOLDER_SET_TYPES);
        putRegister(objectPool, "$IngredientTypes", NeoForgeRegistries.Keys.INGREDIENT_TYPES);
        putRegister(objectPool, "$Instruments", Registries.INSTRUMENT);
        putRegister(objectPool, "$IntProviderTypes", Registries.INT_PROVIDER_TYPE);
        putRegister(objectPool, "$ItemSubPredicateTypes", Registries.ITEM_SUB_PREDICATE_TYPE);
        putRegister(objectPool, "$Items", Registries.ITEM);
        putRegister(objectPool, "$LootConditionTypes", Registries.LOOT_CONDITION_TYPE);
        putRegister(objectPool, "$LootFunctionTypes", Registries.LOOT_FUNCTION_TYPE);
        putRegister(objectPool, "$LootNbtProviderTypes", Registries.LOOT_NBT_PROVIDER_TYPE);
        putRegister(objectPool, "$LootNumberProviderTypes", Registries.LOOT_NUMBER_PROVIDER_TYPE);
        putRegister(objectPool, "$LootPoolEntryTypes", Registries.LOOT_POOL_ENTRY_TYPE);
        putRegister(objectPool, "$LootScoreProviderTypes", Registries.LOOT_SCORE_PROVIDER_TYPE);
        putRegister(objectPool, "$MapDecorationTypes", Registries.MAP_DECORATION_TYPE);
        putRegister(objectPool, "$MaterialConditions", Registries.MATERIAL_CONDITION);
        putRegister(objectPool, "$MaterialRules", Registries.MATERIAL_RULE);
        putRegister(objectPool, "$MemoryModuleTypes", Registries.MEMORY_MODULE_TYPE);
        putRegister(objectPool, "$Menus", Registries.MENU);
        putRegister(objectPool, "$MobEffects", Registries.MOB_EFFECT);
        putRegister(objectPool, "$NumberFormatTypes", Registries.NUMBER_FORMAT_TYPE);
        putRegister(objectPool, "$ParticleTypes", Registries.PARTICLE_TYPE);
        putRegister(objectPool, "$PlacementModifierTypes", Registries.PLACEMENT_MODIFIER_TYPE);
        putRegister(objectPool, "$PointOfInterestTypes", Registries.POINT_OF_INTEREST_TYPE);
        putRegister(objectPool, "$PoolAliasBindings", Registries.POOL_ALIAS_BINDING);
        putRegister(objectPool, "$PositionSourceTypes", Registries.POSITION_SOURCE_TYPE);
        putRegister(objectPool, "$PosRuleTests", Registries.POS_RULE_TEST);
        putRegister(objectPool, "$Potions", Registries.POTION);
        putRegister(objectPool, "$RecipeSerializers", Registries.RECIPE_SERIALIZER);
        putRegister(objectPool, "$RecipeTypes", Registries.RECIPE_TYPE);
        putRegister(objectPool, "$RootPlacerTypes", Registries.ROOT_PLACER_TYPE);
        putRegister(objectPool, "$RuleBlockEntityModifiers", Registries.RULE_BLOCK_ENTITY_MODIFIER);
        putRegister(objectPool, "$RuleTests", Registries.RULE_TEST);
        putRegister(objectPool, "$Schedules", Registries.SCHEDULE);
        putRegister(objectPool, "$SensorTypes", Registries.SENSOR_TYPE);
        putRegister(objectPool, "$SoundEvents", Registries.SOUND_EVENT);
        putRegister(objectPool, "$StatTypes", Registries.STAT_TYPE);
        putRegister(objectPool, "$StructureModifierSerializers", NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS);
        putRegister(objectPool, "$StructurePieces", Registries.STRUCTURE_PIECE);
        putRegister(objectPool, "$StructurePlacements", Registries.STRUCTURE_PLACEMENT);
        putRegister(objectPool, "$StructurePoolElements", Registries.STRUCTURE_POOL_ELEMENT);
        putRegister(objectPool, "$StructureProcessors", Registries.STRUCTURE_PROCESSOR);
        putRegister(objectPool, "$StructureTypes", Registries.STRUCTURE_TYPE);
        putRegister(objectPool, "$TreeDecoratorTypes", Registries.TREE_DECORATOR_TYPE);
        putRegister(objectPool, "$TriggerTypes", Registries.TRIGGER_TYPE);
        putRegister(objectPool, "$TrunkPlacerTypes", Registries.TRUNK_PLACER_TYPE);
        putRegister(objectPool, "$VillagerProfessions", Registries.VILLAGER_PROFESSION);
        putRegister(objectPool, "$VillagerTypes", Registries.VILLAGER_TYPE);
    }

    private <T> void putRegister(final ObjectPool objectPool, final String name, final ResourceKey<Registry<T>> registry) {
        objectPool.put(name, TemporalRegister.create(registry));
    }
}
