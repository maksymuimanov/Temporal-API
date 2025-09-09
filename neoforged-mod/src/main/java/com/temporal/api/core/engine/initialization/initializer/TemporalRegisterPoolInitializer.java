package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class TemporalRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Iterable<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        objectPool.put("$Items", TemporalRegister.createItems());
        objectPool.put("$Blocks", TemporalRegister.createBlocks());
        objectPool.put("$CreativeModeTabs", TemporalRegister.create(Registries.CREATIVE_MODE_TAB));
        objectPool.put("$MobEffects", TemporalRegister.create(Registries.MOB_EFFECT));
        objectPool.put("$EntityTypes", TemporalRegister.create(Registries.ENTITY_TYPE));
        objectPool.put("$BlockEntityTypes", TemporalRegister.create(Registries.BLOCK_ENTITY_TYPE));
        objectPool.put("$ParticleTypes", TemporalRegister.create(Registries.PARTICLE_TYPE));
        objectPool.put("$PoiTypes", TemporalRegister.create(Registries.POINT_OF_INTEREST_TYPE));
        objectPool.put("$Potions", TemporalRegister.create(Registries.POTION));
        objectPool.put("$RecipeSerializers", TemporalRegister.create(Registries.RECIPE_SERIALIZER));
        objectPool.put("$RecipeTypes", TemporalRegister.create(Registries.RECIPE_TYPE));
        objectPool.put("$SoundEvents", TemporalRegister.create(Registries.SOUND_EVENT));
        objectPool.put("$VillagerProfessions", TemporalRegister.create(Registries.VILLAGER_PROFESSION));
        objectPool.put("$GlobalLootModifierSerializers", TemporalRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS));
        objectPool.put("$MenuTypes", TemporalRegister.create(Registries.MENU));
        objectPool.put("$TriggerTypes", TemporalRegister.create(Registries.TRIGGER_TYPE));
        objectPool.put("$ArmorMaterials", TemporalRegister.create(Registries.ARMOR_MATERIAL));
        objectPool.put("$AttachmentTypes", TemporalRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES));
        objectPool.put("$Features", TemporalRegister.create(Registries.FEATURE));
        objectPool.put("$Carvers", TemporalRegister.create(Registries.CARVER));
        objectPool.put("$DataComponentTypes", TemporalRegister.create(Registries.DATA_COMPONENT_TYPE));
        objectPool.put("$Fluids", TemporalRegister.create(Registries.FLUID));
        objectPool.put("$FluidTypes", TemporalRegister.create(NeoForgeRegistries.FLUID_TYPES));
        objectPool.put("$FoliagePlacerTypes", TemporalRegister.create(Registries.FOLIAGE_PLACER_TYPE));
        objectPool.put("$TreeDecoratorTypes", TemporalRegister.create(Registries.TREE_DECORATOR_TYPE));
        objectPool.put("$TrunkPlacerTypes", TemporalRegister.create(Registries.TRUNK_PLACER_TYPE));
    }
}
