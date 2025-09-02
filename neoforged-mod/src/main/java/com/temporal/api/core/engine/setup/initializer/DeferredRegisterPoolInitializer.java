package com.temporal.api.core.engine.setup.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class DeferredRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        objectPool.putObject("$Items", TemporalRegister.createItems());
        objectPool.putObject("$Blocks", TemporalRegister.createBlocks());
        objectPool.putObject("$Biomes", TemporalRegister.create(Registries.BIOME));
        objectPool.putObject("$CreativeModeTabs", TemporalRegister.create(Registries.CREATIVE_MODE_TAB));
        objectPool.putObject("$MobEffects", TemporalRegister.create(Registries.MOB_EFFECT));
        objectPool.putObject("$EntityTypes", TemporalRegister.create(Registries.ENTITY_TYPE));
        objectPool.putObject("$BlockEntityTypes", TemporalRegister.create(Registries.BLOCK_ENTITY_TYPE));
        objectPool.putObject("$ParticleTypes", TemporalRegister.create(Registries.PARTICLE_TYPE));
        objectPool.putObject("$PoiTypes", TemporalRegister.create(Registries.POINT_OF_INTEREST_TYPE));
        objectPool.putObject("$Potions", TemporalRegister.create(Registries.POTION));
        objectPool.putObject("$RecipeSerializers", TemporalRegister.create(Registries.RECIPE_SERIALIZER));
        objectPool.putObject("$SoundEvents", TemporalRegister.create(Registries.SOUND_EVENT));
        objectPool.putObject("$VillagerProfessions", TemporalRegister.create(Registries.VILLAGER_PROFESSION));
        objectPool.putObject("$GlobalLootModifierSerializers", TemporalRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS));
        objectPool.putObject("$MenuTypes", TemporalRegister.create(Registries.MENU));
        objectPool.putObject("$TriggerTypes", TemporalRegister.create(Registries.TRIGGER_TYPE));
        objectPool.putObject("$ArmorMaterials", TemporalRegister.create(Registries.ARMOR_MATERIAL));
    }
}
