package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class TemporalRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        objectPool.putObject("$Items", TemporalRegister.createItems());
        objectPool.putObject("$Blocks", TemporalRegister.createBlocks());
        objectPool.putObject("$CreativeModeTabs", TemporalRegister.create(Registries.CREATIVE_MODE_TAB));
        objectPool.putObject("$MobEffects", TemporalRegister.create(Registries.MOB_EFFECT));
        objectPool.putObject("$EntityTypes", TemporalRegister.create(Registries.ENTITY_TYPE));
        objectPool.putObject("$BlockEntityTypes", TemporalRegister.create(Registries.BLOCK_ENTITY_TYPE));
        objectPool.putObject("$ParticleTypes", TemporalRegister.create(Registries.PARTICLE_TYPE));
        objectPool.putObject("$PoiTypes", TemporalRegister.create(Registries.POINT_OF_INTEREST_TYPE));
        objectPool.putObject("$Potions", TemporalRegister.create(Registries.POTION));
        objectPool.putObject("$RecipeSerializers", TemporalRegister.create(Registries.RECIPE_SERIALIZER));
        objectPool.putObject("$RecipeTypes", TemporalRegister.create(Registries.RECIPE_TYPE));
        objectPool.putObject("$SoundEvents", TemporalRegister.create(Registries.SOUND_EVENT));
        objectPool.putObject("$VillagerProfessions", TemporalRegister.create(Registries.VILLAGER_PROFESSION));
        objectPool.putObject("$GlobalLootModifierSerializers", TemporalRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS));
        objectPool.putObject("$MenuTypes", TemporalRegister.create(Registries.MENU));
        objectPool.putObject("$TriggerTypes", TemporalRegister.create(Registries.TRIGGER_TYPE));
        objectPool.putObject("$ArmorMaterials", TemporalRegister.create(Registries.ARMOR_MATERIAL));
        objectPool.putObject("$AttachmentTypes", TemporalRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES));
        objectPool.putObject("$Carvers", TemporalRegister.create(Registries.CARVER));
        objectPool.putObject("$DataComponentTypes", TemporalRegister.create(Registries.DATA_COMPONENT_TYPE));
        objectPool.putObject("$Fluids", TemporalRegister.create(Registries.FLUID));
        objectPool.putObject("$FluidTypes", TemporalRegister.create(NeoForgeRegistries.FLUID_TYPES));
        objectPool.putObject("$FoliagePlacerTypes", TemporalRegister.create(Registries.FOLIAGE_PLACER_TYPE));
        objectPool.putObject("$TreeDecoratorTypes", TemporalRegister.create(Registries.TREE_DECORATOR_TYPE));
        objectPool.putObject("$TrunkPlacerTypes", TemporalRegister.create(Registries.TRUNK_PLACER_TYPE));
    }
}
