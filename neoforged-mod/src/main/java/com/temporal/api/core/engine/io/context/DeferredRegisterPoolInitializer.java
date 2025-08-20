package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class DeferredRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(List<?> externalObjects) {
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.putObject("$Items", RegistryUtils.createItemRegistry());
        objectPool.putObject("$Blocks", RegistryUtils.createBlockRegistry());
        objectPool.putObject("$Biomes", RegistryUtils.createRegistry(Registries.BIOME));
        objectPool.putObject("$CreativeModeTabs", RegistryUtils.createRegistry(Registries.CREATIVE_MODE_TAB));
        objectPool.putObject("$MobEffects", RegistryUtils.createRegistry(Registries.MOB_EFFECT));
        objectPool.putObject("$EntityTypes", RegistryUtils.createRegistry(Registries.ENTITY_TYPE));
        objectPool.putObject("$BlockEntityTypes", RegistryUtils.createRegistry(Registries.BLOCK_ENTITY_TYPE));
        objectPool.putObject("$ParticleTypes", RegistryUtils.createRegistry(Registries.PARTICLE_TYPE));
        objectPool.putObject("$PoiTypes", RegistryUtils.createRegistry(Registries.POINT_OF_INTEREST_TYPE));
        objectPool.putObject("$Potions", RegistryUtils.createRegistry(Registries.POTION));
        objectPool.putObject("$RecipeSerializers", RegistryUtils.createRegistry(Registries.RECIPE_SERIALIZER));
        objectPool.putObject("$SoundEvents", RegistryUtils.createRegistry(Registries.SOUND_EVENT));
        objectPool.putObject("$VillagerProfessions", RegistryUtils.createRegistry(Registries.VILLAGER_PROFESSION));
        objectPool.putObject("$GlobalLootModifierSerializers", RegistryUtils.createRegistry(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS));
        objectPool.putObject("$MenuTypes", RegistryUtils.createRegistry(Registries.MENU));
        objectPool.putObject("$TriggerTypes", RegistryUtils.createRegistry(Registries.TRIGGER_TYPE));
        objectPool.putObject("$ArmorMaterials", RegistryUtils.createRegistry(Registries.ARMOR_MATERIAL));
    }
}
