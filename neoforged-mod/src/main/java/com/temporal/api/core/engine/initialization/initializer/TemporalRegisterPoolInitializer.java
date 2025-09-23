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
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        this.putRegister(objectPool, "$Activities", Registries.ACTIVITY);
        this.putRegister(objectPool, "$ArmorMaterials", Registries.ARMOR_MATERIAL);
        this.putRegister(objectPool, "$AttachmentTypes", NeoForgeRegistries.Keys.ATTACHMENT_TYPES);
        this.putRegister(objectPool, "$Attributes", Registries.ATTRIBUTE);
        this.putRegister(objectPool, "$BiomeModifierSerializers", NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS);
        this.putRegister(objectPool, "$BiomeSources", Registries.BIOME_SOURCE);
        this.putRegister(objectPool, "$BlockEntityTypes", Registries.BLOCK_ENTITY_TYPE);
        this.putRegister(objectPool, "$BlockPredicateTypes", Registries.BLOCK_PREDICATE_TYPE);
        this.putRegister(objectPool, "$BlockStateProviderTypes", Registries.BLOCK_STATE_PROVIDER_TYPE);
        objectPool.put("$Blocks", TemporalRegister.createBlocks());
        this.putRegister(objectPool, "$BlockTypes", Registries.BLOCK_TYPE);
        this.putRegister(objectPool, "$Carvers", Registries.CARVER);
        this.putRegister(objectPool, "$ChunkGenerators", Registries.CHUNK_GENERATOR);
        this.putRegister(objectPool, "$CommandArgumentTypes", Registries.COMMAND_ARGUMENT_TYPE);
        this.putRegister(objectPool, "$ConditionCodecs", NeoForgeRegistries.Keys.CONDITION_CODECS);
        this.putRegister(objectPool, "$CreativeModeTabs", Registries.CREATIVE_MODE_TAB);
        this.putRegister(objectPool, "$CustomStats", Registries.CUSTOM_STAT);
        this.putRegister(objectPool, "$DataComponentTypes", Registries.DATA_COMPONENT_TYPE);
        this.putRegister(objectPool, "$DensityFunctionTypes", Registries.DENSITY_FUNCTION_TYPE);
        this.putRegister(objectPool, "$EnchantmentEffectComponentTypes", Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
        this.putRegister(objectPool, "$EnchantmentEntityEffectTypes", Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE);
        this.putRegister(objectPool, "$EnchantmentLevelBasedValueTypes", Registries.ENCHANTMENT_LEVEL_BASED_VALUE_TYPE);
        this.putRegister(objectPool, "$EnchantmentLocationBasedEffectTypes", Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE);
        this.putRegister(objectPool, "$EnchantmentProviderTypes", Registries.ENCHANTMENT_PROVIDER_TYPE);
        this.putRegister(objectPool, "$EnchantmentValueEffectTypes", Registries.ENCHANTMENT_VALUE_EFFECT_TYPE);
        this.putRegister(objectPool, "$EntityDataSerializers", NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS);
        this.putRegister(objectPool, "$EntitySubPredicateTypes", Registries.ENTITY_SUB_PREDICATE_TYPE);
        this.putRegister(objectPool, "$EntityTypes", Registries.ENTITY_TYPE);
        this.putRegister(objectPool, "$FeatureSizeTypes", Registries.FEATURE_SIZE_TYPE);
        this.putRegister(objectPool, "$Features", Registries.FEATURE);
        this.putRegister(objectPool, "$FloatProviderTypes", Registries.FLOAT_PROVIDER_TYPE);
        this.putRegister(objectPool, "$FluidIngredientTypes", NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES);
        this.putRegister(objectPool, "$Fluids", Registries.FLUID);
        this.putRegister(objectPool, "$FluidTypes", NeoForgeRegistries.Keys.FLUID_TYPES);
        this.putRegister(objectPool, "$FoliagePlacerTypes", Registries.FOLIAGE_PLACER_TYPE);
        this.putRegister(objectPool, "$GameEvents", Registries.GAME_EVENT);
        this.putRegister(objectPool, "$GlobalLootModifierSerializers", NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS);
        this.putRegister(objectPool, "$HeightProviderTypes", Registries.HEIGHT_PROVIDER_TYPE);
        this.putRegister(objectPool, "$HolderSetTypes", NeoForgeRegistries.Keys.HOLDER_SET_TYPES);
        this.putRegister(objectPool, "$IngredientTypes", NeoForgeRegistries.Keys.INGREDIENT_TYPES);
        this.putRegister(objectPool, "$IntProviderTypes", Registries.INT_PROVIDER_TYPE);
        this.putRegister(objectPool, "$ItemSubPredicateTypes", Registries.ITEM_SUB_PREDICATE_TYPE);
        objectPool.put("$Items", TemporalRegister.createItems());
        this.putRegister(objectPool, "$LootConditionTypes", Registries.LOOT_CONDITION_TYPE);
        this.putRegister(objectPool, "$LootFunctionTypes", Registries.LOOT_FUNCTION_TYPE);
        this.putRegister(objectPool, "$LootNbtProviderTypes", Registries.LOOT_NBT_PROVIDER_TYPE);
        this.putRegister(objectPool, "$LootNumberProviderTypes", Registries.LOOT_NUMBER_PROVIDER_TYPE);
        this.putRegister(objectPool, "$LootPoolEntryTypes", Registries.LOOT_POOL_ENTRY_TYPE);
        this.putRegister(objectPool, "$LootScoreProviderTypes", Registries.LOOT_SCORE_PROVIDER_TYPE);
        this.putRegister(objectPool, "$MapDecorationTypes", Registries.MAP_DECORATION_TYPE);
        this.putRegister(objectPool, "$MaterialConditions", Registries.MATERIAL_CONDITION);
        this.putRegister(objectPool, "$MaterialRules", Registries.MATERIAL_RULE);
        this.putRegister(objectPool, "$MemoryModuleTypes", Registries.MEMORY_MODULE_TYPE);
        this.putRegister(objectPool, "$Menus", Registries.MENU);
        this.putRegister(objectPool, "$MobEffects", Registries.MOB_EFFECT);
        this.putRegister(objectPool, "$NumberFormatTypes", Registries.NUMBER_FORMAT_TYPE);
        this.putRegister(objectPool, "$ParticleTypes", Registries.PARTICLE_TYPE);
        this.putRegister(objectPool, "$PlacementModifierTypes", Registries.PLACEMENT_MODIFIER_TYPE);
        this.putRegister(objectPool, "$PointOfInterestTypes", Registries.POINT_OF_INTEREST_TYPE);
        this.putRegister(objectPool, "$PositionSourceTypes", Registries.POSITION_SOURCE_TYPE);
        this.putRegister(objectPool, "$PosRuleTests", Registries.POS_RULE_TEST);
        this.putRegister(objectPool, "$Potions", Registries.POTION);
        this.putRegister(objectPool, "$RecipeSerializers", Registries.RECIPE_SERIALIZER);
        this.putRegister(objectPool, "$RecipeTypes", Registries.RECIPE_TYPE);
        this.putRegister(objectPool, "$RootPlacerTypes", Registries.ROOT_PLACER_TYPE);
        this.putRegister(objectPool, "$RuleBlockEntityModifiers", Registries.RULE_BLOCK_ENTITY_MODIFIER);
        this.putRegister(objectPool, "$RuleTests", Registries.RULE_TEST);
        this.putRegister(objectPool, "$Schedules", Registries.SCHEDULE);
        this.putRegister(objectPool, "$SensorTypes", Registries.SENSOR_TYPE);
        this.putRegister(objectPool, "$SoundEvents", Registries.SOUND_EVENT);
        this.putRegister(objectPool, "$StatTypes", Registries.STAT_TYPE);
        this.putRegister(objectPool, "$StructureModifierSerializers", NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS);
        this.putRegister(objectPool, "$StructurePieces", Registries.STRUCTURE_PIECE);
        this.putRegister(objectPool, "$StructurePlacements", Registries.STRUCTURE_PLACEMENT);
        this.putRegister(objectPool, "$StructurePoolElements", Registries.STRUCTURE_POOL_ELEMENT);
        this.putRegister(objectPool, "$StructureProcessors", Registries.STRUCTURE_PROCESSOR);
        this.putRegister(objectPool, "$StructureTypes", Registries.STRUCTURE_TYPE);
        this.putRegister(objectPool, "$TreeDecoratorTypes", Registries.TREE_DECORATOR_TYPE);
        this.putRegister(objectPool, "$TriggerTypes", Registries.TRIGGER_TYPE);
        this.putRegister(objectPool, "$TrunkPlacerTypes", Registries.TRUNK_PLACER_TYPE);
        this.putRegister(objectPool, "$VillagerProfessions", Registries.VILLAGER_PROFESSION);
        this.putRegister(objectPool, "$VillagerTypes", Registries.VILLAGER_TYPE);
        this.putRegister(objectPool, "$Instruments", Registries.INSTRUMENT);
        this.putRegister(objectPool, "$CatVariants", Registries.CAT_VARIANT);
    }

    private <T> void putRegister(ObjectPool objectPool, String name, ResourceKey<Registry<T>> registry) {
        objectPool.put(name, TemporalRegister.create(registry));
    }
}
